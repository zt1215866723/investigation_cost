package com.xwkj.cost.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xwkj.cost.common.LoginUserInfoManager;
import com.xwkj.cost.mapper.ApplyInvoiceInfoMapperManual;
import com.xwkj.cost.mapper.ContractInfoMapperManual;
import com.xwkj.cost.mapper.MoneyBackInfoMapperManual;
import com.xwkj.cost.mapper.auto.ContractInfoMapper;
import com.xwkj.cost.mapper.auto.EnclosureInfoMapper;
import com.xwkj.cost.model.ContractInfo;
import com.xwkj.cost.model.EnclosureInfo;
import com.xwkj.cost.model.UserInfo;
import com.xwkj.cost.service.ContractInfoService;
import com.xwkj.cost.util.PageUtil;
import com.xwkj.cost.vo.ContractInfoAndInvoiceInfoVo;
import com.xwkj.cost.vo.ContractInfoVo;
import com.xwkj.cost.vo.MoneyBackVo;
import com.xwkj.cost.vo.SelectContractInfoVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Description:TODO 合同业务层实现
 * @Author wanglei
 * @Create 2019-12-11 9:32
 * @Version 1.0
 */
@Service
public class ContractInfoServiceImpl implements ContractInfoService {

	@Autowired
	ContractInfoMapperManual contractInfoMapperManual;

	@Autowired
	ContractInfoMapper contractInfoMapper;

	@Autowired
	EnclosureInfoMapper enclosureInfoMapper;

	@Autowired
	MoneyBackInfoMapperManual moneyBackInfoMapperManual;

	@Autowired
	ApplyInvoiceInfoMapperManual applyInvoiceInfoMapperManual;
	/***
	 * @description: 添加合同附件信息
	 * @methodName: addContractInfoAndAnnex
	 * @param: [contractInfoVo]
	 * @return: void
	 * @exception:
	 * @date:  2019-12-11 9:45
	 * @author: wanglei
	 */
	@Override
	public Long addContractInfoAndAnnex(ContractInfoVo contractInfoVo, String[] titleTrueName) {
		ContractInfo contractInfo = new ContractInfo();
		BeanUtils.copyProperties(contractInfoVo,contractInfo);
		contractInfo.setCreatTime(new Date());
		contractInfo.setLastModifiedTime(new Date());
		//查询登陆信息
		UserInfo userInfo = LoginUserInfoManager.getUserInfo();
		if (userInfo != null) {
			contractInfo.setCreator(userInfo.getId());
			contractInfo.setLastModifier(userInfo.getId());
		}else{
			return Long.parseLong("-1");
		}
		//返回插入合同主键
		contractInfoMapperManual.insertSelective(contractInfo);
		Long id = contractInfo.getId();
		if (id != null){
			//添加合同附件信息
			String fileUploads = contractInfoVo.getFileUploads();
			if (fileUploads != null && StringUtils.isNotBlank(fileUploads)){
				String[] filePaths = fileUploads.split(",");
				for (int i = 0; i < filePaths.length; i++) {
					if (StringUtils.isNotBlank(filePaths[i])) {
						EnclosureInfo enclosureInfo = new EnclosureInfo();
						enclosureInfo.setContractId(id);
						enclosureInfo.setFileName(titleTrueName[i]);
						enclosureInfo.setFilePath(filePaths[i]);
						enclosureInfo.setCreateTime(new Date());
						this.enclosureInfoMapper.insertSelective(enclosureInfo);
					}
				}
			}
		}
		return id;
	}

	/**
	 * @description: 查询合同信息接口实现
	 * @methodName: getContractInfo
	 * @param: [pageUtil, selectContractInfoVo]
	 * @return: com.github.pagehelper.PageInfo<com.xwkj.cost.vo.ContractInfoAndInvoiceInfoVo>
	 * @exception:
	 * @date:  2019-12-11 15:07
	 * @author: wanglei
	 */
	@Override
	public PageInfo<ContractInfoAndInvoiceInfoVo> getContractInfo(PageUtil pageUtil, SelectContractInfoVo selectContractInfoVo) {
		if ((pageUtil.getLimit() != null) && (pageUtil.getPage() != null)) {
			PageHelper.startPage(pageUtil.getPage().intValue(), pageUtil.getLimit().intValue());
		}
		List<ContractInfoAndInvoiceInfoVo> list = this.contractInfoMapperManual.selectSelective(selectContractInfoVo);
		for (ContractInfoAndInvoiceInfoVo contractInfoAndInvoiceInfoVo : list)
		{
			contractInfoAndInvoiceInfoVo.setStartTime(selectContractInfoVo.getStartTime());
			contractInfoAndInvoiceInfoVo.setEndTime(selectContractInfoVo.getEndTime());

			MoneyBackVo sumAndCount = this.moneyBackInfoMapperManual.getSumAndCount(contractInfoAndInvoiceInfoVo.setHasInvoice(null));
			contractInfoAndInvoiceInfoVo.setMoneySum(sumAndCount.getMoneySum());

			MoneyBackVo sumAndCount2 = this.moneyBackInfoMapperManual.getSumAndCount(contractInfoAndInvoiceInfoVo.setHasInvoice(Integer.valueOf(1)));
			contractInfoAndInvoiceInfoVo.setYesOpenMoneySum(sumAndCount2.getMoneySum());

			MoneyBackVo sumAndCount1 = this.applyInvoiceInfoMapperManual.getSumAndCount(contractInfoAndInvoiceInfoVo);
			contractInfoAndInvoiceInfoVo.setOpenMoneySum(sumAndCount1.getMoneySum());

			contractInfoAndInvoiceInfoVo.setNoOpenMoneySum(sumAndCount1.getMoneySum().subtract(sumAndCount2.getMoneySum()));

			contractInfoAndInvoiceInfoVo.setNoMoneySum(contractInfoAndInvoiceInfoVo.getContractMoney().subtract(sumAndCount.getMoneySum()));

			List<MoneyBackVo> sumAndCount3 = this.applyInvoiceInfoMapperManual.getApplyTime(contractInfoAndInvoiceInfoVo.getId());

			contractInfoAndInvoiceInfoVo.setNoOpenNoMoneySum(contractInfoAndInvoiceInfoVo.getNoMoneySum().subtract(contractInfoAndInvoiceInfoVo.getNoOpenMoneySum()));
			if (sumAndCount3 != null)
			{
				String s = new String();
				for (MoneyBackVo moneyBackVo : sumAndCount3) {
					s = s + moneyBackVo.getApplyTime() + "\r\n";
				}
				contractInfoAndInvoiceInfoVo.setOpenTime(s);
			}
		}
		return new PageInfo(list);
	}

	/**
	 * @description: 修改合同信息接口实现
	 * @methodName: editContractInfo
	 * @param: [contractInfo]
	 * @return: Boolean
	 * @exception:
	 * @date:  2019-12-12 10:33
	 * @author: wanglei
	 */
	@Override
	public Boolean editContractInfo(ContractInfo contractInfo, String[] titleTrueName) {
		Boolean flag = Boolean.valueOf(true);

		UserInfo userInfo = LoginUserInfoManager.getUserInfo();
		if (userInfo != null)
		{
			contractInfo.setLastModifier(userInfo.getId());
			this.contractInfoMapper.updateByPrimaryKeySelective(contractInfo);

			String fileUploads = contractInfo.getFileUploads();
			if ((fileUploads != null) && (StringUtils.isNotBlank(fileUploads)))
			{
				String[] filePaths = fileUploads.split(",");
				for (int i = 0; i < filePaths.length; i++) {
					if (StringUtils.isNotBlank(filePaths[i]))
					{
						EnclosureInfo enclosureInfo = new EnclosureInfo();
						enclosureInfo.setContractId(contractInfo.getId());
						enclosureInfo.setFileName(titleTrueName[i]);
						enclosureInfo.setFilePath(filePaths[i]);
						enclosureInfo.setCreateTime(new Date());
						this.enclosureInfoMapper.insertSelective(enclosureInfo);
					}
				}
			}
		}
		else
		{
			flag = Boolean.valueOf(false);
		}
		return flag;
	}

	/**
	 * @description: 批量删除合同接口
	 * @methodName: delContractInfo
	 * @param: [contractIds]
	 * @return: Boolean
	 * @exception:
	 * @date:  2019-12-12 16:43
	 * @author: wanglei
	 */
	@Override
	public Boolean delContractInfo(Long[] contractIds) {
		ContractInfo contractInfo = new ContractInfo();
		UserInfo userInfo = LoginUserInfoManager.getUserInfo();
		for (Long contractId : contractIds) {
			if (userInfo != null) {
				contractInfo.setLastModifier(userInfo.getId());
				contractInfo.setId(contractId);
				contractInfo.setStatus(0);
				contractInfoMapper.updateByPrimaryKeySelective(contractInfo);
			}else{
				return false;
			}
		}
		return true;
	}
}
