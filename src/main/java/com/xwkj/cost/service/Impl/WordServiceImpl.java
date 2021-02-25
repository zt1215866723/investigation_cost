package com.xwkj.cost.service.Impl;

import com.xwkj.cost.mapper.*;
import com.xwkj.cost.mapper.auto.ContractInfoMapper;
import com.xwkj.cost.model.ContractAdjust;
import com.xwkj.cost.model.MoneyBackInfo;
import com.xwkj.cost.model.ProjectType;
import com.xwkj.cost.service.*;
import com.xwkj.cost.util.DateUtil;
import com.xwkj.cost.vo.*;
import lombok.SneakyThrows;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipOutputStream;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STMerge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Description:TODO 生成word实现
 * @Author wanglei
 * @Create 2019-12-13 9:12
 * @Version 1.0
 */
@Service
public class WordServiceImpl implements WordService {

    @Autowired
    ContractInfoMapper contractInfoMapper;

    @Autowired
    MoneyBackInfoService moneyBackInfoService;

    @Autowired
    CostTypeInfoService costTypeInfoService;

    @Autowired
    ContractCostTypeRelatedService contractCostTypeRelatedService;

    @Autowired
    SubContractInfoService subContractInfoService;

    @Autowired
    ContractInfoMapperManual contractInfoMapperManual;

    @Autowired
    ApplyInvoiceInfoMapperManual applyInvoiceInfoMapperManual;

    @Autowired
    MoneyBackInfoMapperManual moneyBackInfoMapperManual;

    @Autowired
    ContractAdjustMapperManual contractAdjustMapperManual;

    @Autowired
    ProjectTypeMapperManual projectTypeMapperManual;

    /**
     * @description: 打印合同成本报表接口实现
     * @methodName: printfContractWord
     * @param: [contractIds, response]
     * @return: void
     * @exception:
     * @date: 2019-12-13 21:58
     * @author: wanglei
     */
    @SneakyThrows
    @Override
    public void printfContractWord(String[] contractId, Integer type, HttpServletResponse response) {

        List<ContractInfoAndInvoiceInfoVo> list = this.contractInfoMapperManual.selectBycontrackIds(contractId);

        HSSFWorkbook workbook = new HSSFWorkbook();

        HSSFCellStyle style = workbook.createCellStyle();

        HSSFCellStyle hStyle = workbook.createCellStyle();

        HSSFCellStyle ordinaryFontStyle = workbook.createCellStyle();
        HSSFFont font = workbook.createFont();
        HSSFFont ordinaryFont = workbook.createFont();
        font.setFontName("宋体");
        font.setFontHeightInPoints((short) 11);

        font.setBoldweight((short) 700);
        style.setWrapText(true);
        style.setFont(font);
        style.setAlignment((short) 2);
        style.setVerticalAlignment((short) 1);

        style.setBorderBottom((short) 1);
        style.setBorderLeft((short) 1);
        style.setBorderTop((short) 1);
        style.setBorderRight((short) 1);

        hStyle.setFont(ordinaryFont);
        hStyle.setAlignment((short) 2);
        hStyle.setVerticalAlignment((short) 1);
        hStyle.setWrapText(true);

        ordinaryFont.setFontName("宋体");
        ordinaryFont.setFontHeightInPoints((short) 11);
        ordinaryFontStyle.setFont(ordinaryFont);
        ordinaryFontStyle.setAlignment((short) 2);
        ordinaryFontStyle.setVerticalAlignment((short) 6);

        HSSFSheet sheet = workbook.createSheet("未收款项目对账表");

        int rowNum = 0;

        HSSFRow row = sheet.createRow(rowNum);

        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 12));
        HSSFCell cell = row.createCell(0);
        cell.setCellStyle(style);
        if (type == 1) {
            //未收款项目对账表
            cell.setCellValue("未收款项目对账表");
        } else if (type == 2) {
            //开票未收款项目对账表
            cell.setCellValue("开票未收款项目对账表");
        } else if (type == 3) {
            //未开票未收款项目对账表
            cell.setCellValue("未开票未收款项目对账表");
        }
        cell = row.createCell(1);
        cell.setCellStyle(style);
        cell = row.createCell(2);
        cell.setCellStyle(style);
        cell = row.createCell(3);
        cell.setCellStyle(style);
        cell = row.createCell(4);
        cell.setCellStyle(style);
        cell = row.createCell(5);
        cell.setCellStyle(style);
        cell = row.createCell(6);
        cell.setCellStyle(style);
        cell = row.createCell(7);
        cell.setCellStyle(style);
        cell = row.createCell(8);
        cell.setCellStyle(style);
        cell = row.createCell(9);
        cell.setCellStyle(style);
        cell = row.createCell(10);
        cell.setCellStyle(style);
        cell = row.createCell(11);
        cell.setCellStyle(style);
        cell = row.createCell(12);
        cell.setCellStyle(style);
        cell = row.createCell(13);
        cell.setCellStyle(style);

        sheet.setColumnWidth(1, 1536);
        sheet.setColumnWidth(2, 3072);
        sheet.setColumnWidth(3, 2560);
        sheet.setColumnWidth(4, 2560);
        sheet.setColumnWidth(5, 2560);
        sheet.setColumnWidth(6, 3072);
        sheet.setColumnWidth(7, 3072);
        sheet.setColumnWidth(8, 3072);
        sheet.setColumnWidth(9, 2560);
        sheet.setColumnWidth(10, 2560);
        sheet.setColumnWidth(11, 2560);
        sheet.setColumnWidth(12, 2560);
        sheet.setColumnWidth(13, 2560);
        sheet.setColumnWidth(14, 2560);

        rowNum++;
        row = sheet.createRow(rowNum);
        cell = row.createCell(0);
        cell.setCellStyle(style);
        cell.setCellValue("业务员");

        cell = row.createCell(1);
        cell.setCellStyle(style);
        cell.setCellValue("年份");

        cell = row.createCell(2);
        cell.setCellStyle(style);
        cell.setCellValue("合同编号");
        cell = row.createCell(3);
        cell.setCellStyle(style);
        cell.setCellValue("工程项目");

        cell = row.createCell(4);
        cell.setCellStyle(style);
        cell.setCellValue("付款单位");

        cell = row.createCell(5);
        cell.setCellStyle(style);
        cell.setCellValue("合同金额");
        cell = row.createCell(6);
        cell.setCellStyle(style);
        cell.setCellValue("开票时间");

        cell = row.createCell(7);
        cell.setCellStyle(style);
        cell.setCellValue("回款次数");

        cell = row.createCell(8);
        cell.setCellStyle(style);
        cell.setCellValue("已开票金额");

        cell = row.createCell(9);
        cell.setCellStyle(style);
        cell.setCellValue("已收金额");
        cell = row.createCell(10);
        cell.setCellStyle(style);
        cell.setCellValue("开票未收");
        cell = row.createCell(11);
        cell.setCellStyle(style);
        cell.setCellValue("未开票未收");


        cell = row.createCell(12);
        cell.setCellStyle(style);
        cell.setCellValue("未收金额");

        cell = row.createCell(13);
        cell.setCellStyle(style);
        cell.setCellValue("备注");
        cell = row.createCell(14);
        cell.setCellStyle(style);
        cell.setCellValue("类别");
        for (int i = 0; i < list.size(); i++) {
            ContractInfoAndInvoiceInfoVo contractInfoAndInvoiceInfoVo = list.get(i);

            MoneyBackVo sumAndCount = this.moneyBackInfoMapperManual.getSumAndCount(contractInfoAndInvoiceInfoVo.setHasInvoice(null));
            //已收金额
            contractInfoAndInvoiceInfoVo.setMoneySum(sumAndCount.getMoneySum());

            if (contractInfoAndInvoiceInfoVo.getContractMoney().compareTo(contractInfoAndInvoiceInfoVo.getMoneySum()) == 1) {

                MoneyBackVo sumAndCount2 = this.moneyBackInfoMapperManual.getSumAndCount(contractInfoAndInvoiceInfoVo.setHasInvoice(Integer.valueOf(1)));

                MoneyBackVo sumAndCount1 = this.applyInvoiceInfoMapperManual.getSumAndCount(contractInfoAndInvoiceInfoVo);
                //已开票金额
                contractInfoAndInvoiceInfoVo.setOpenMoneySum(sumAndCount1.getMoneySum());
                //开票未收
                contractInfoAndInvoiceInfoVo.setNoOpenMoneySum(sumAndCount1.getMoneySum().subtract(sumAndCount2.getMoneySum()));
                //未收金额
                contractInfoAndInvoiceInfoVo.setNoMoneySum(contractInfoAndInvoiceInfoVo.getContractMoney().subtract(sumAndCount.getMoneySum()));

                //未开票未收金额 = 未收金额 - 开票未收金额
                contractInfoAndInvoiceInfoVo.setNoOpenNoMoneySum(contractInfoAndInvoiceInfoVo.getNoMoneySum().subtract(contractInfoAndInvoiceInfoVo.getNoOpenMoneySum()));

                List<MoneyBackVo> sumAndCount3 = this.applyInvoiceInfoMapperManual.getApplyTime(contractInfoAndInvoiceInfoVo.getId());

                List<MoneyBackVo> sumAndCount4 = this.moneyBackInfoMapperManual.getMoneyBackTime(contractInfoAndInvoiceInfoVo.getId());

                if (type == 1) {
                    //未收款项目对账表
                } else if (type == 2) {
                    //开票未收款项目对账表
                    if (contractInfoAndInvoiceInfoVo.getNoOpenMoneySum().compareTo(BigDecimal.ZERO) == 0) {
                        continue;
                    }
                } else if (type == 3) {
                    //未开票未收项目对账表
                    if (contractInfoAndInvoiceInfoVo.getNoOpenNoMoneySum().compareTo(BigDecimal.ZERO) == 0) {
                        continue;
                    }
                }

                rowNum++;
                row = sheet.createRow(rowNum);
                cell = row.createCell(0);
                cell.setCellStyle(style);
                cell.setCellValue(contractInfoAndInvoiceInfoVo.getManagerName());

                cell = row.createCell(1);
                cell.setCellStyle(style);
                cell.setCellValue(contractInfoAndInvoiceInfoVo.getSigningTime());

                cell = row.createCell(2);
                cell.setCellStyle(style);
                cell.setCellValue(contractInfoAndInvoiceInfoVo.getContractNum());

                cell = row.createCell(3);
                cell.setCellStyle(style);
                cell.setCellValue(contractInfoAndInvoiceInfoVo.getItemName());

                cell = row.createCell(4);
                cell.setCellStyle(style);
                cell.setCellValue(contractInfoAndInvoiceInfoVo.getCompany());

                cell = row.createCell(5);
                cell.setCellStyle(style);
                cell.setCellValue(contractInfoAndInvoiceInfoVo.getContractMoney().stripTrailingZeros().toPlainString());

                cell = row.createCell(6);
                cell.setCellStyle(style);
                if (sumAndCount3 != null) {
                    String s = new String();
                    for (MoneyBackVo moneyBackVo : sumAndCount3) {
                        if (moneyBackVo!=null){
                            s = s + moneyBackVo.getApplyTime() + "\r\n";
                        }
                    }
                    cell.setCellValue(s);
                }
                cell = row.createCell(7);
                cell.setCellStyle(style);
                if (sumAndCount3 != null) {
                    String s1 = new String();
                    for (MoneyBackVo moneyBackVo : sumAndCount4) {
                        if (moneyBackVo!=null) {
                            s1 = s1 + moneyBackVo.getMoneyBackTime() + "\r\n";
                        }
                    }
                    cell.setCellValue(s1);
                }
                cell = row.createCell(8);
                cell.setCellStyle(style);
                cell.setCellValue(contractInfoAndInvoiceInfoVo.getOpenMoneySum().stripTrailingZeros().toPlainString());

                cell = row.createCell(9);
                cell.setCellStyle(style);
                cell.setCellValue(contractInfoAndInvoiceInfoVo.getMoneySum().stripTrailingZeros().toPlainString());
                cell = row.createCell(10);
                cell.setCellStyle(style);
                cell.setCellValue(contractInfoAndInvoiceInfoVo.getNoOpenMoneySum().stripTrailingZeros().toPlainString());
                cell = row.createCell(11);
                cell.setCellStyle(style);
                cell.setCellValue(contractInfoAndInvoiceInfoVo.getNoOpenNoMoneySum().stripTrailingZeros().toPlainString());

                cell = row.createCell(12);
                cell.setCellStyle(style);
                cell.setCellValue(contractInfoAndInvoiceInfoVo.getNoMoneySum().stripTrailingZeros().toPlainString());

                cell = row.createCell(13);
                cell.setCellStyle(style);
                cell.setCellValue(contractInfoAndInvoiceInfoVo.getConclusion());
                cell = row.createCell(14);
                cell.setCellStyle(style);
                cell.setCellValue(contractInfoAndInvoiceInfoVo.getTypeName());
            }
        }
        rowNum++;
        row = sheet.createRow(rowNum);
        cell = row.createCell(0);
        cell.setCellStyle(style);
        cell.setCellValue("合计");
        BigDecimal bigDecimal = new BigDecimal("0");
        BigDecimal bigDecimal1 = new BigDecimal("0");
        BigDecimal bigDecimal2 = new BigDecimal("0");
        BigDecimal bigDecimal3 = new BigDecimal("0");
        BigDecimal bigDecimal4 = new BigDecimal("0");
        BigDecimal bigDecimal5 = new BigDecimal("0");
        for (int i = 0; i < list.size(); i++) {
            ContractInfoAndInvoiceInfoVo contractInfoAndInvoiceInfoVo = list.get(i);
            if (contractInfoAndInvoiceInfoVo.getContractMoney().compareTo(contractInfoAndInvoiceInfoVo.getMoneySum()) == 1) {

                if (type == 1) {
                    //未收款项目对账表
                } else if (type == 2) {
                    //开票未收款项目对账表
                    if (contractInfoAndInvoiceInfoVo.getNoOpenMoneySum().compareTo(BigDecimal.ZERO) == 0) {
                        continue;
                    }
                } else if (type == 3) {
                    //未开票未收项目对账表
                    if (contractInfoAndInvoiceInfoVo.getNoOpenNoMoneySum().compareTo(BigDecimal.ZERO) == 0) {
                        continue;
                    }
                }

                bigDecimal = bigDecimal.add(contractInfoAndInvoiceInfoVo.getContractMoney());
                bigDecimal1 = bigDecimal1.add(contractInfoAndInvoiceInfoVo.getOpenMoneySum());
                bigDecimal2 = bigDecimal2.add(contractInfoAndInvoiceInfoVo.getMoneySum());
                bigDecimal3 = bigDecimal3.add(contractInfoAndInvoiceInfoVo.getNoOpenMoneySum());
                bigDecimal4 = bigDecimal4.add(contractInfoAndInvoiceInfoVo.getNoMoneySum());
                bigDecimal5 = bigDecimal5.add(contractInfoAndInvoiceInfoVo.getNoOpenNoMoneySum());
            }
        }


        cell = row.createCell(1);
        cell.setCellStyle(style);
        cell = row.createCell(2);
        cell.setCellStyle(style);
        cell = row.createCell(3);
        cell.setCellStyle(style);
        cell = row.createCell(4);
        cell.setCellStyle(style);
        cell = row.createCell(5);
        cell.setCellStyle(style);
        cell.setCellValue(bigDecimal.stripTrailingZeros().toPlainString());
        cell = row.createCell(6);
        cell.setCellStyle(style);
        cell = row.createCell(7);
        cell.setCellStyle(style);
        cell = row.createCell(8);
        cell.setCellStyle(style);
        cell.setCellValue(bigDecimal1.stripTrailingZeros().toPlainString());
        cell = row.createCell(9);
        cell.setCellStyle(style);
        cell.setCellValue(bigDecimal2.stripTrailingZeros().toPlainString());
        cell = row.createCell(10);
        cell.setCellStyle(style);
        cell.setCellValue(bigDecimal3.stripTrailingZeros().toPlainString());
        cell = row.createCell(11);
        cell.setCellStyle(style);
        cell.setCellValue(bigDecimal5.stripTrailingZeros().toPlainString());
        cell = row.createCell(12);
        cell.setCellStyle(style);
        cell.setCellValue(bigDecimal4.stripTrailingZeros().toPlainString());
        cell = row.createCell(13);
        cell.setCellStyle(style);
        cell = row.createCell(14);
        cell.setCellStyle(style);

        rowNum++;
        rowNum++;
        sheet.addMergedRegion(new CellRangeAddress(rowNum, rowNum, 11, 12));
        sheet.addMergedRegion(new CellRangeAddress(rowNum, rowNum, 4, 5));
        row = sheet.createRow(rowNum);
        cell = row.createCell(0);
        cell.setCellStyle(hStyle);
        cell.setCellValue("核对人");
        cell = row.createCell(1);
        cell.setCellStyle(hStyle);
        cell = row.createCell(2);
        cell.setCellStyle(hStyle);
        cell = row.createCell(3);
        cell.setCellStyle(hStyle);
        cell = row.createCell(4);
        cell.setCellStyle(hStyle);
        cell.setCellValue("业务员签字");
        cell = row.createCell(5);
        cell.setCellStyle(hStyle);
        cell = row.createCell(6);
        cell.setCellStyle(hStyle);
        cell = row.createCell(7);
        cell.setCellStyle(hStyle);
        cell = row.createCell(8);
        cell.setCellStyle(hStyle);
        cell = row.createCell(9);
        cell.setCellStyle(hStyle);
        cell = row.createCell(10);
        cell.setCellStyle(hStyle);
        cell.setCellValue("日期");
        cell = row.createCell(11);
        cell.setCellStyle(hStyle);
        cell = row.createCell(12);
        cell.setCellStyle(hStyle);
        cell.setCellValue(DateUtil.dateToString(new Date(), "yyyy-MM-dd"));
        cell = row.createCell(13);
        cell.setCellStyle(hStyle);

        response.setContentType("application/octet-stream");

        if (type == 1) {
            //未收款项目对账表
            response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode("未收款项目对账表.xls", "UTF-8"));

        } else if (type == 2) {
            //开票未收款项目对账表
            response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode("开票未收款项目对账表.xls", "UTF-8"));

        } else if (type == 3) {
            //未开票未收款项目对账表
            response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode("未开票未收款项目对账表.xls", "UTF-8"));

        }

        response.flushBuffer();

        workbook.write(response.getOutputStream());
    }

    @SneakyThrows
    @Override
    public void invoiceStatisticsExcel(SelectContractInfoVo selectContractInfoVo, HttpServletResponse response) {
        List<InvoiceStatisticsVo> list = this.applyInvoiceInfoMapperManual.getInvoiceStatistics(selectContractInfoVo);

        HSSFWorkbook workbook = new HSSFWorkbook();

        HSSFCellStyle style = workbook.createCellStyle();

        HSSFCellStyle hStyle = workbook.createCellStyle();

        HSSFCellStyle ordinaryFontStyle = workbook.createCellStyle();
        HSSFFont font = workbook.createFont();
        HSSFFont ordinaryFont = workbook.createFont();
        font.setFontName("宋体");
        font.setFontHeightInPoints((short) 11);

        font.setBoldweight((short) 700);
        style.setWrapText(true);
        style.setFont(font);
        style.setAlignment((short) 2);
        style.setVerticalAlignment((short) 1);

        style.setBorderBottom((short) 1);
        style.setBorderLeft((short) 1);
        style.setBorderTop((short) 1);
        style.setBorderRight((short) 1);

        hStyle.setFont(ordinaryFont);
        hStyle.setAlignment((short) 2);
        hStyle.setVerticalAlignment((short) 1);
        hStyle.setWrapText(true);

        ordinaryFont.setFontName("宋体");
        ordinaryFont.setFontHeightInPoints((short) 11);
        ordinaryFontStyle.setFont(ordinaryFont);
        ordinaryFontStyle.setAlignment((short) 2);
        ordinaryFontStyle.setVerticalAlignment((short) 6);

        HSSFSheet sheet = workbook.createSheet("发票统计");

        int rowNum = 0;

        HSSFRow row = sheet.createRow(rowNum);

        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 8));
        HSSFCell cell = row.createCell(0);
        cell.setCellStyle(style);
        if ((selectContractInfoVo.getStart() != null) && (selectContractInfoVo.getEnd() != null)) {
            cell.setCellValue("廊坊市城市建设勘察院发票统计表（" + DateUtil.dateToString(selectContractInfoVo.getStart(), "yyyy-MM-dd") + "-" + DateUtil.dateToString(selectContractInfoVo.getEnd(), "yyyy-MM-dd") + "）");
        } else {
            cell.setCellValue("廊坊市城市建设勘察院发票统计表");
        }
        cell = row.createCell(1);
        cell.setCellStyle(style);
        cell = row.createCell(2);
        cell.setCellStyle(style);
        cell = row.createCell(3);
        cell.setCellStyle(style);
        cell = row.createCell(4);
        cell.setCellStyle(style);
        cell = row.createCell(5);
        cell.setCellStyle(style);
        cell = row.createCell(6);
        cell.setCellStyle(style);
        cell = row.createCell(7);
        cell.setCellStyle(style);
        cell = row.createCell(8);
        cell.setCellStyle(style);
        cell = row.createCell(9);
        cell.setCellStyle(style);

        sheet.setColumnWidth(0, 1536);
        sheet.setColumnWidth(1, 3328);
        sheet.setColumnWidth(2, 5120);
        sheet.setColumnWidth(3, 6400);
        sheet.setColumnWidth(4, 2304);
        sheet.setColumnWidth(5, 4096);
        sheet.setColumnWidth(6, 2816);
        sheet.setColumnWidth(7, 4096);
        sheet.setColumnWidth(8, 2816);
        sheet.setColumnWidth(9, 2816);
        sheet.setColumnWidth(10, 5120);

        rowNum++;
        row = sheet.createRow(rowNum);
        cell = row.createCell(0);
        cell.setCellStyle(style);
        cell.setCellValue("年份");

        cell = row.createCell(1);
        cell.setCellStyle(style);
        cell.setCellValue("时间");

        cell = row.createCell(2);
        cell.setCellStyle(style);
        cell.setCellValue("单位名称");
        cell = row.createCell(3);
        cell.setCellStyle(style);
        cell.setCellValue("工程项目");

        cell = row.createCell(4);
        cell.setCellStyle(style);
        cell.setCellValue("业务员");

        cell = row.createCell(5);
        cell.setCellStyle(style);
        cell.setCellValue("开票凭证号");

        cell = row.createCell(6);
        cell.setCellStyle(style);
        cell.setCellValue("开票金额");
        cell = row.createCell(7);
        cell.setCellStyle(style);
        cell.setCellValue("回款凭证号");

        cell = row.createCell(8);
        cell.setCellStyle(style);
        cell.setCellValue("回款时间");

        cell = row.createCell(9);
        cell.setCellStyle(style);
        cell.setCellValue("回款金额");

        cell = row.createCell(10);
        cell.setCellStyle(style);
        cell.setCellValue("备注");
        for (int i = 0; i < list.size(); i++) {
            InvoiceStatisticsVo invoiceStatisticsVo = (InvoiceStatisticsVo) list.get(i);

            rowNum++;
            row = sheet.createRow(rowNum);
            cell = row.createCell(0);
            cell.setCellStyle(style);
            cell.setCellValue(invoiceStatisticsVo.getSigningTime());

            cell = row.createCell(1);
            cell.setCellStyle(style);
            cell.setCellValue(invoiceStatisticsVo.getApplyTime());

            cell = row.createCell(2);
            cell.setCellStyle(style);
            cell.setCellValue(invoiceStatisticsVo.getCompany());

            cell = row.createCell(3);
            cell.setCellStyle(style);
            cell.setCellValue(invoiceStatisticsVo.getItemName());

            cell = row.createCell(4);
            cell.setCellStyle(style);
            cell.setCellValue(invoiceStatisticsVo.getManagerName());

            cell = row.createCell(5);
            cell.setCellStyle(style);
            cell.setCellValue(invoiceStatisticsVo.getApplyName());

            cell = row.createCell(6);
            cell.setCellStyle(style);
            cell.setCellValue(invoiceStatisticsVo.getApplyMoney().stripTrailingZeros().toPlainString());

            cell = row.createCell(7);
            cell.setCellStyle(style);
            cell.setCellValue(invoiceStatisticsVo.getCertificateNumber());

            cell = row.createCell(8);
            cell.setCellStyle(style);
            cell.setCellValue(invoiceStatisticsVo.getArrivalTime());

            cell = row.createCell(9);
            cell.setCellStyle(style);
            cell.setCellValue(invoiceStatisticsVo.getBackMoney().stripTrailingZeros().toPlainString());

            cell = row.createCell(10);
            cell.setCellStyle(style);
            cell.setCellValue(invoiceStatisticsVo.getInvaiceRemark());
        }
        response.setContentType("application/octet-stream");

        response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode("发票统计.xls", "UTF-8"));

        response.flushBuffer();

        workbook.write(response.getOutputStream());
    }

    @SneakyThrows
    @Override
    public void moneyBackStatisticsExcel(SelectContractInfoVo selectContractInfoVo, HttpServletResponse response) {
        List<InvoiceStatisticsVo> list = this.moneyBackInfoMapperManual.getMoneyBackStatistics(selectContractInfoVo);

        HSSFWorkbook workbook = new HSSFWorkbook();

        HSSFCellStyle style = workbook.createCellStyle();

        HSSFCellStyle hStyle = workbook.createCellStyle();

        HSSFCellStyle ordinaryFontStyle = workbook.createCellStyle();
        HSSFFont font = workbook.createFont();
        HSSFFont ordinaryFont = workbook.createFont();
        font.setFontName("宋体");
        font.setFontHeightInPoints((short) 11);

        font.setBoldweight((short) 700);
        style.setWrapText(true);
        style.setFont(font);
        style.setAlignment((short) 2);
        style.setVerticalAlignment((short) 1);

        style.setBorderBottom((short) 1);
        style.setBorderLeft((short) 1);
        style.setBorderTop((short) 1);
        style.setBorderRight((short) 1);

        hStyle.setFont(ordinaryFont);
        hStyle.setAlignment((short) 2);
        hStyle.setVerticalAlignment((short) 1);
        hStyle.setWrapText(true);

        ordinaryFont.setFontName("宋体");
        ordinaryFont.setFontHeightInPoints((short) 11);
        ordinaryFontStyle.setFont(ordinaryFont);
        ordinaryFontStyle.setAlignment((short) 2);
        ordinaryFontStyle.setVerticalAlignment((short) 6);

        HSSFSheet sheet = workbook.createSheet("回款统计");

        int rowNum = 0;

        HSSFRow row = sheet.createRow(rowNum);

        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 8));
        HSSFCell cell = row.createCell(0);
        cell.setCellStyle(style);
        if ((selectContractInfoVo.getStart() != null) && (selectContractInfoVo.getEnd() != null)) {
            cell.setCellValue("廊坊市城市建设勘察院回款统计表（" + DateUtil.dateToString(selectContractInfoVo.getStart(), "yyyy-MM-dd") + "-" + DateUtil.dateToString(selectContractInfoVo.getEnd(), "yyyy-MM-dd") + "）");
        } else {
            cell.setCellValue("廊坊市城市建设勘察院回款统计表");
        }
        cell = row.createCell(1);
        cell.setCellStyle(style);
        cell = row.createCell(2);
        cell.setCellStyle(style);
        cell = row.createCell(3);
        cell.setCellStyle(style);
        cell = row.createCell(4);
        cell.setCellStyle(style);
        cell = row.createCell(5);
        cell.setCellStyle(style);
        cell = row.createCell(6);
        cell.setCellStyle(style);
        cell = row.createCell(7);
        cell.setCellStyle(style);
        cell = row.createCell(8);
        cell.setCellStyle(style);
        cell = row.createCell(9);
        cell.setCellStyle(style);

        sheet.setColumnWidth(0, 1536);
        sheet.setColumnWidth(1, 3328);
        sheet.setColumnWidth(2, 5120);
        sheet.setColumnWidth(3, 6400);
        sheet.setColumnWidth(4, 2304);
        sheet.setColumnWidth(5, 4096);
        sheet.setColumnWidth(6, 2816);
        sheet.setColumnWidth(7, 4096);
        sheet.setColumnWidth(8, 2816);
        sheet.setColumnWidth(9, 5120);

        rowNum++;
        row = sheet.createRow(rowNum);
        cell = row.createCell(0);
        cell.setCellStyle(style);
        cell.setCellValue("年份");

        cell = row.createCell(1);
        cell.setCellStyle(style);
        cell.setCellValue("时间");

        cell = row.createCell(2);
        cell.setCellStyle(style);
        cell.setCellValue("单位名称");
        cell = row.createCell(3);
        cell.setCellStyle(style);
        cell.setCellValue("工程项目");

        cell = row.createCell(4);
        cell.setCellStyle(style);
        cell.setCellValue("业务员");

        cell = row.createCell(5);
        cell.setCellStyle(style);
        cell.setCellValue("开票凭证号");

        cell = row.createCell(6);
        cell.setCellStyle(style);
        cell.setCellValue("开票金额");
        cell = row.createCell(7);
        cell.setCellStyle(style);
        cell.setCellValue("回款凭证号");

        cell = row.createCell(8);
        cell.setCellStyle(style);
        cell.setCellValue("回款金额");

        cell = row.createCell(9);
        cell.setCellStyle(style);
        cell.setCellValue("备注");
        for (int i = 0; i < list.size(); i++) {
            InvoiceStatisticsVo invoiceStatisticsVo = (InvoiceStatisticsVo) list.get(i);

            rowNum++;
            row = sheet.createRow(rowNum);
            cell = row.createCell(0);
            cell.setCellStyle(style);
            cell.setCellValue(invoiceStatisticsVo.getSigningTime());

            cell = row.createCell(1);
            cell.setCellStyle(style);
            cell.setCellValue(invoiceStatisticsVo.getApplyTime());

            cell = row.createCell(2);
            cell.setCellStyle(style);
            cell.setCellValue(invoiceStatisticsVo.getCompany());

            cell = row.createCell(3);
            cell.setCellStyle(style);
            cell.setCellValue(invoiceStatisticsVo.getItemName());

            cell = row.createCell(4);
            cell.setCellStyle(style);
            cell.setCellValue(invoiceStatisticsVo.getManagerName());

            cell = row.createCell(5);
            cell.setCellStyle(style);
            cell.setCellValue(invoiceStatisticsVo.getApplyName());

            cell = row.createCell(6);
            cell.setCellStyle(style);
            cell.setCellValue(invoiceStatisticsVo.getApplyMoney().stripTrailingZeros().toPlainString());

            cell = row.createCell(7);
            cell.setCellStyle(style);
            cell.setCellValue(invoiceStatisticsVo.getCertificateNumber());

            cell = row.createCell(8);
            cell.setCellStyle(style);
            cell.setCellValue(invoiceStatisticsVo.getBackMoney().stripTrailingZeros().toPlainString());

            cell = row.createCell(9);
            cell.setCellStyle(style);
            cell.setCellValue(invoiceStatisticsVo.getInvaiceRemark());
        }
        response.setContentType("application/octet-stream");

        response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode("回款统计.xls", "UTF-8"));

        response.flushBuffer();

        workbook.write(response.getOutputStream());
    }

    @SneakyThrows
    @Override
    public void printfYearSummary(String timeLimit, HttpServletResponse response) {

        SelectContractInfoVo selectContractInfoVo = new SelectContractInfoVo();

        if (timeLimit != null && timeLimit != "") {
            String[] split = timeLimit.split(" - ");
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
            try {
                Calendar calendar = new GregorianCalendar();
                calendar.setTime(formatter.parse(split[1]));
                calendar.add(Calendar.DATE, 1);
                selectContractInfoVo.setEnd(calendar.getTime());
                selectContractInfoVo.setStart(formatter.parse(split[0]));
                selectContractInfoVo.setStartT(String.valueOf(split[0]));
                selectContractInfoVo.setEndT(String.valueOf(split[1]));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // 返回的日期集合
        List<String> days = new ArrayList<String>();

        DateFormat dateFormat = new SimpleDateFormat("yyyy");

        Calendar tempStart = Calendar.getInstance();
        tempStart.setTime(selectContractInfoVo.getStart());

        Calendar tempEnd = Calendar.getInstance();
        tempEnd.setTime(selectContractInfoVo.getEnd());
        tempEnd.add(Calendar.DATE, +1);// 日期加1(包含结束)
        while (tempStart.before(tempEnd)) {
            days.add(dateFormat.format(tempStart.getTime()));
            tempStart.add(Calendar.YEAR, 1);
        }


        List<ContractSummaryVo> list = this.contractInfoMapperManual.selectYearSummary(selectContractInfoVo);

        HSSFWorkbook workbook = new HSSFWorkbook();

        HSSFCellStyle style = workbook.createCellStyle();

        HSSFCellStyle hStyle = workbook.createCellStyle();

        HSSFCellStyle ordinaryFontStyle = workbook.createCellStyle();
        HSSFFont font = workbook.createFont();
        HSSFFont ordinaryFont = workbook.createFont();
        font.setFontName("宋体");
        font.setFontHeightInPoints((short) 11);

        font.setBoldweight((short) 700);
        style.setWrapText(true);
        style.setFont(font);
        style.setAlignment((short) 2);
        style.setVerticalAlignment((short) 1);

        style.setBorderBottom((short) 1);
        style.setBorderLeft((short) 1);
        style.setBorderTop((short) 1);
        style.setBorderRight((short) 1);

        hStyle.setFont(ordinaryFont);
        hStyle.setAlignment((short) 2);
        hStyle.setVerticalAlignment((short) 1);
        hStyle.setWrapText(true);

        ordinaryFont.setFontName("宋体");
        ordinaryFont.setFontHeightInPoints((short) 11);
        ordinaryFontStyle.setFont(ordinaryFont);
        ordinaryFontStyle.setAlignment((short) 2);
        ordinaryFontStyle.setVerticalAlignment((short) 6);

        HSSFSheet sheet = workbook.createSheet("年度汇总表");

        sheet.setColumnWidth(0, 5120);
        for (int i = 0; i < days.size(); i++) {
            sheet.setColumnWidth(i + 1, 5120);
        }
        sheet.setColumnWidth(days.size() + 1, 5120);


        int rowNum = 0;

        HSSFRow row = sheet.createRow(rowNum);

        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, days.size() + 1));
        HSSFCell cell = row.createCell(0);
        cell.setCellStyle(style);
        cell.setCellValue("廊坊市城市建设勘察院工程合同收款统计表");
        for (int i = 0; i < days.size()+1; i++) {
            cell = row.createCell(i+1);
            cell.setCellStyle(style);
        }

        rowNum++;
        row = sheet.createRow(rowNum);
        cell = row.createCell(0);
        cell.setCellStyle(style);

        for (int i = 0; i < days.size(); i++) {
            cell = row.createCell(i + 1);
            cell.setCellStyle(style);
            cell.setCellValue(days.get(i));
        }

        cell = row.createCell(days.size() + 1);
        cell.setCellStyle(style);
        cell.setCellValue("合计");

        //

        List<ProjectType> projectTypeList = projectTypeMapperManual.getProjectTypeList(null);

        for (ProjectType projectType : projectTypeList) {
            rowNum++;
            row = sheet.createRow(rowNum);
            cell = row.createCell(0);
            cell.setCellStyle(style);
            cell.setCellValue(projectType.getName());

            for (int i = 0; i < days.size(); i++) {
                cell = row.createCell(i + 1);
                cell.setCellStyle(style);
            }

            cell = row.createCell(days.size() + 1);
            cell.setCellStyle(style);

            rowNum++;
            row = sheet.createRow(rowNum);
            cell = row.createCell(0);
            cell.setCellStyle(style);
            cell.setCellValue("合同金额");

            BigDecimal sumContractMoney = new BigDecimal("0");

            for (int i = 0; i < days.size(); i++) {
                BigDecimal contractMoney = new BigDecimal("0");
                for (ContractSummaryVo contractSummaryVo : list) {
                    if (projectType.getId().equals(contractSummaryVo.getProjectId())) {
                        if (contractSummaryVo.getSigningTime().equals(days.get(i))) {
                            contractMoney = contractMoney.add(contractSummaryVo.getContractMoney());
                            break;
                        }
                    }
                }
                sumContractMoney = sumContractMoney.add(contractMoney);
                cell = row.createCell(i + 1);
                cell.setCellStyle(style);
                cell.setCellValue(contractMoney.stripTrailingZeros().toPlainString());
            }

            cell = row.createCell(days.size() + 1);
            cell.setCellStyle(style);
            cell.setCellValue(sumContractMoney.stripTrailingZeros().toPlainString());

            //已收
            rowNum++;
            row = sheet.createRow(rowNum);
            cell = row.createCell(0);
            cell.setCellStyle(style);
            cell.setCellValue("已收");

            BigDecimal sumArriveMoney = new BigDecimal("0");

            for (int i = 0; i < days.size(); i++) {
                BigDecimal arriveMoney = new BigDecimal("0");
                for (ContractSummaryVo contractSummaryVo : list) {
                    if (projectType.getId().equals(contractSummaryVo.getProjectId())) {
                        if (contractSummaryVo.getSigningTime().equals(days.get(i))) {
                            arriveMoney = arriveMoney.add(contractSummaryVo.getArriveMoney());
                            break;
                        }
                    }
                }
                sumArriveMoney = sumArriveMoney.add(arriveMoney);
                cell = row.createCell(i + 1);
                cell.setCellStyle(style);
                cell.setCellValue(arriveMoney.stripTrailingZeros().toPlainString());
            }

            cell = row.createCell(days.size() + 1);
            cell.setCellStyle(style);
            cell.setCellValue(sumArriveMoney.stripTrailingZeros().toPlainString());

            //未收
            rowNum++;
            row = sheet.createRow(rowNum);
            cell = row.createCell(0);
            cell.setCellStyle(style);
            cell.setCellValue("未收");

            BigDecimal sumNoArriveMoney = sumContractMoney.subtract(sumArriveMoney);

            for (int i = 0; i < days.size(); i++) {
                BigDecimal noArriveMoney = new BigDecimal("0");
                for (ContractSummaryVo contractSummaryVo : list) {
                    if (projectType.getId().equals(contractSummaryVo.getProjectId())) {
                        if (contractSummaryVo.getSigningTime().equals(days.get(i))) {
                            noArriveMoney = noArriveMoney.add(contractSummaryVo.getContractMoney().subtract(contractSummaryVo.getArriveMoney()));
                            break;
                        }
                    }
                }
                cell = row.createCell(i + 1);
                cell.setCellStyle(style);
                cell.setCellValue(noArriveMoney.stripTrailingZeros().toPlainString());
            }

            cell = row.createCell(days.size() + 1);
            cell.setCellStyle(style);
            cell.setCellValue(sumNoArriveMoney.stripTrailingZeros().toPlainString());

        }

        rowNum++;
        row = sheet.createRow(rowNum);
        cell = row.createCell(0);
        cell.setCellStyle(style);
        cell.setCellValue("未收合计");

        BigDecimal wsMoney = new BigDecimal("0");

        for (int i = 0; i < days.size(); i++) {
            BigDecimal bigDecimal = new BigDecimal("0");
            for (ContractSummaryVo contractSummaryVo : list) {
                if (days.get(i).equals(contractSummaryVo.getSigningTime())) {
                    bigDecimal = bigDecimal.add(contractSummaryVo.getContractMoney().subtract(contractSummaryVo.getArriveMoney()));
                }
            }
            cell = row.createCell(i + 1);
            cell.setCellStyle(style);
            cell.setCellValue(bigDecimal.stripTrailingZeros().toPlainString());
            wsMoney = wsMoney.add(bigDecimal);
        }

        cell = row.createCell(days.size() + 1);
        cell.setCellStyle(style);
        cell.setCellValue(wsMoney.stripTrailingZeros().toPlainString());

        rowNum++;
        row = sheet.createRow(rowNum);
        cell = row.createCell(0);
        cell.setCellStyle(style);
        cell.setCellValue("总合同额");

        BigDecimal zeMoney = new BigDecimal("0");

        for (int i = 0; i < days.size(); i++) {
            BigDecimal bigDecimal = new BigDecimal("0");
            for (ContractSummaryVo contractSummaryVo : list) {
                if (days.get(i).equals(contractSummaryVo.getSigningTime())) {
                    bigDecimal = bigDecimal.add(contractSummaryVo.getContractMoney());
                }
            }
            cell = row.createCell(i + 1);
            cell.setCellStyle(style);
            cell.setCellValue(bigDecimal.stripTrailingZeros().toPlainString());
            zeMoney = zeMoney.add(bigDecimal);
        }

        cell = row.createCell(days.size() + 1);
        cell.setCellStyle(style);
        cell.setCellValue(zeMoney.stripTrailingZeros().toPlainString());

        DecimalFormat df = new DecimalFormat("0.00%");

        rowNum++;
        row = sheet.createRow(rowNum);
        cell = row.createCell(0);
        cell.setCellStyle(style);
        cell.setCellValue("未收比例");

        for (int i = 0; i < days.size(); i++) {
            BigDecimal bigDecimal1 = new BigDecimal("0");
            BigDecimal bigDecimal2 = new BigDecimal("0");
            for (ContractSummaryVo contractSummaryVo : list) {
                if (days.get(i).equals(contractSummaryVo.getSigningTime())) {
                    if (contractSummaryVo.getContractMoney().compareTo(new BigDecimal("0")) == 1 && contractSummaryVo.getArriveMoney().compareTo(new BigDecimal("0")) == 1) {
                        bigDecimal1 = bigDecimal1.add(contractSummaryVo.getContractMoney().subtract(contractSummaryVo.getArriveMoney()));
                        bigDecimal2 = bigDecimal2.add(contractSummaryVo.getContractMoney());
                    }
                }
            }
            cell = row.createCell(i + 1);
            cell.setCellStyle(style);
            if (bigDecimal1.compareTo(new BigDecimal("0")) == 1 && bigDecimal2.compareTo(new BigDecimal("0")) == 1) {
                cell.setCellValue(df.format(bigDecimal1.divide(bigDecimal2, 4, BigDecimal.ROUND_HALF_UP)));
            }
        }

        cell = row.createCell(days.size() + 1);
        cell.setCellStyle(style);
        if (wsMoney.compareTo(new BigDecimal("0")) == 1 && zeMoney.compareTo(new BigDecimal("0")) == 1) {
            cell.setCellValue(df.format(wsMoney.divide(zeMoney, 4, BigDecimal.ROUND_HALF_UP)));
        }

        response.setContentType("application/octet-stream");

        response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode("年度汇总表.xls", "UTF-8"));

        response.flushBuffer();

        workbook.write(response.getOutputStream());
    }


    /**
     * @description: 打印合同汇总报表接口实现
     * @methodName: printfContractSummary
     * @param: [contractIds, response]
     * @return: void
     * @exception:
     * @date: 2019-12-13 21:58
     * @author: zt
     */
    @SneakyThrows
    @Override
    public void printfContractSummary(String[] contractId, HttpServletResponse response) {

        List<ContractSummaryVo> list = this.contractInfoMapperManual.selectContractSummary(contractId);

        HSSFWorkbook workbook = new HSSFWorkbook();

        HSSFCellStyle style = workbook.createCellStyle();

        HSSFCellStyle hStyle = workbook.createCellStyle();

        HSSFCellStyle ordinaryFontStyle = workbook.createCellStyle();
        HSSFFont font = workbook.createFont();
        HSSFFont ordinaryFont = workbook.createFont();
        font.setFontName("宋体");
        font.setFontHeightInPoints((short) 11);

        font.setBoldweight((short) 700);
        style.setWrapText(true);
        style.setFont(font);
        style.setAlignment((short) 2);
        style.setVerticalAlignment((short) 1);

        style.setBorderBottom((short) 1);
        style.setBorderLeft((short) 1);
        style.setBorderTop((short) 1);
        style.setBorderRight((short) 1);

        hStyle.setFont(ordinaryFont);
        hStyle.setAlignment((short) 2);
        hStyle.setVerticalAlignment((short) 1);
        hStyle.setWrapText(true);

        ordinaryFont.setFontName("宋体");
        ordinaryFont.setFontHeightInPoints((short) 11);
        ordinaryFontStyle.setFont(ordinaryFont);
        ordinaryFontStyle.setAlignment((short) 2);
        ordinaryFontStyle.setVerticalAlignment((short) 6);

        HSSFSheet sheet = workbook.createSheet("合同汇总表");

        int rowNum = 0;

        HSSFRow row = sheet.createRow(rowNum);

        sheet.addMergedRegion(new CellRangeAddress(0, 1, 0, 0));
        sheet.addMergedRegion(new CellRangeAddress(0, 1, 1, 1));
        sheet.addMergedRegion(new CellRangeAddress(0, 1, 2, 2));
        sheet.addMergedRegion(new CellRangeAddress(0, 1, 3, 3));
        sheet.addMergedRegion(new CellRangeAddress(0, 1, 4, 4));
        sheet.addMergedRegion(new CellRangeAddress(0, 1, 5, 5));
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 6, 7));
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 8, 9));
        sheet.addMergedRegion(new CellRangeAddress(0, 1, 10, 10));
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 11, 12));
        sheet.addMergedRegion(new CellRangeAddress(0, 1, 13, 13));

        row = sheet.createRow(rowNum);
        HSSFCell cell = row.createCell(0);
        cell.setCellStyle(style);
        cell.setCellValue("业务员");

        cell = row.createCell(1);
        cell.setCellStyle(style);
        cell.setCellValue("合同编号");

        cell = row.createCell(2);
        cell.setCellStyle(style);
        cell.setCellValue("工程名称");
        cell = row.createCell(3);
        cell.setCellStyle(style);
        cell.setCellValue("付款单位");

        cell = row.createCell(4);
        cell.setCellStyle(style);
        cell.setCellValue("合同金额");

        cell = row.createCell(5);
        cell.setCellStyle(style);
        cell.setCellValue("调整");
        cell = row.createCell(6);
        cell.setCellStyle(style);
        cell.setCellValue("开票情况");

        cell = row.createCell(7);
        cell.setCellStyle(style);

        cell = row.createCell(8);
        cell.setCellStyle(style);
        cell.setCellValue("回款情况");
        cell = row.createCell(9);
        cell.setCellStyle(style);

        cell = row.createCell(10);
        cell.setCellStyle(style);
        cell.setCellValue("已收金额");

        cell = row.createCell(11);
        cell.setCellStyle(style);
        cell.setCellValue("尚欠金额");
        cell = row.createCell(12);
        cell.setCellStyle(style);
        cell = row.createCell(13);
        cell.setCellStyle(style);
        cell.setCellValue("备注");

        rowNum++;
        row = sheet.createRow(rowNum);
        cell = row.createCell(0);
        cell.setCellStyle(style);

        cell = row.createCell(1);
        cell.setCellStyle(style);

        cell = row.createCell(2);
        cell.setCellStyle(style);
        cell = row.createCell(3);
        cell.setCellStyle(style);

        cell = row.createCell(4);
        cell.setCellStyle(style);

        cell = row.createCell(5);
        cell.setCellStyle(style);
        cell = row.createCell(6);
        cell.setCellStyle(style);
        cell.setCellValue("凭证号");

        cell = row.createCell(7);
        cell.setCellStyle(style);
        cell.setCellValue("开票金额");

        cell = row.createCell(8);
        cell.setCellStyle(style);
        cell.setCellValue("凭证号");

        cell = row.createCell(9);
        cell.setCellStyle(style);
        cell.setCellValue("金额");

        cell = row.createCell(10);
        cell.setCellStyle(style);

        cell = row.createCell(11);
        cell.setCellStyle(style);
        cell.setCellValue("已开票欠款");

        cell = row.createCell(12);
        cell.setCellStyle(style);
        cell.setCellValue("未开票欠款");

        cell = row.createCell(13);
        cell.setCellStyle(style);
        sheet.setColumnWidth(1, 2560);
        sheet.setColumnWidth(2, 2560);
        sheet.setColumnWidth(3, 2560);
        for (int i = 0; i < list.size(); i++) {
            ContractSummaryVo contractSummaryVo = (ContractSummaryVo) list.get(i);
            ContractInfoAndInvoiceInfoVo contractInfoAndInvoiceInfoVo = new ContractInfoAndInvoiceInfoVo();
            contractInfoAndInvoiceInfoVo.setId(contractSummaryVo.getContractId());

            MoneyBackVo sumAndCount = this.moneyBackInfoMapperManual.getSumAndCount(contractInfoAndInvoiceInfoVo.setHasInvoice(null));
            contractSummaryVo.setMoneySum(sumAndCount.getMoneySum());

            MoneyBackVo sumAndCount2 = this.moneyBackInfoMapperManual.getSumAndCount(contractInfoAndInvoiceInfoVo.setHasInvoice(Integer.valueOf(1)));

            MoneyBackVo sumAndCount1 = this.applyInvoiceInfoMapperManual.getSumAndCount(contractInfoAndInvoiceInfoVo);

            contractSummaryVo.setNoOpenMoneySum(sumAndCount1.getMoneySum().subtract(sumAndCount2.getMoneySum()));

            contractSummaryVo.setNoMoneySum(contractSummaryVo.getContractMoney().subtract(sumAndCount.getMoneySum()).subtract(contractSummaryVo.getNoOpenMoneySum()));

            ContractAdjust contractAdjust = new ContractAdjust();
            contractAdjust.setContractId(contractSummaryVo.getContractId());
            List<ContractAdjust> adjustmentList = this.contractAdjustMapperManual.getAdjustmentList(contractAdjust);

            BigDecimal bigDecimal = new BigDecimal("0");
            for (ContractAdjust contract : adjustmentList) {
                if (contract.getStatus().intValue() == 0) {
                    bigDecimal = bigDecimal.subtract(contract.getMoney());
                } else if (contract.getStatus().intValue() == 1) {
                    bigDecimal = bigDecimal.add(contract.getMoney());
                }
            }
            if (bigDecimal.compareTo(BigDecimal.ZERO) == 1) {
                contractSummaryVo.setAdjustment("+" + bigDecimal.stripTrailingZeros().toPlainString());
            } else {
                contractSummaryVo.setAdjustment(bigDecimal.stripTrailingZeros().toPlainString());
            }
            if ((contractSummaryVo.getMoneyBackList().size() != 0) && (contractSummaryVo.getApplyList().size() != 0)) {
                int a = contractSummaryVo.getApplyList().size() > contractSummaryVo.getMoneyBackList().size() ? contractSummaryVo.getApplyList().size() : contractSummaryVo.getMoneyBackList().size();
                rowNum++;
                row = sheet.createRow(rowNum);
                cell = row.createCell(0);
                cell.setCellStyle(style);
                cell.setCellValue(contractSummaryVo.getManagerName());

                cell = row.createCell(1);
                cell.setCellStyle(style);
                cell.setCellValue(contractSummaryVo.getContractNum());

                cell = row.createCell(2);
                cell.setCellStyle(style);
                cell.setCellValue(contractSummaryVo.getItemName());

                cell = row.createCell(3);
                cell.setCellStyle(style);
                cell.setCellValue(contractSummaryVo.getCompany());

                cell = row.createCell(4);
                cell.setCellStyle(style);
                cell.setCellValue(contractSummaryVo.getContractMoney().stripTrailingZeros().toPlainString());

                cell = row.createCell(5);
                cell.setCellStyle(style);
                cell.setCellValue(contractSummaryVo.getAdjustment());

                cell = row.createCell(6);
                cell.setCellStyle(style);
                cell.setCellValue(((ApplyInvoiceVo) contractSummaryVo.getApplyList().get(0)).getName());

                cell = row.createCell(7);
                cell.setCellStyle(style);
                cell.setCellValue(((ApplyInvoiceVo) contractSummaryVo.getApplyList().get(0)).getMoney().stripTrailingZeros().toPlainString());

                cell = row.createCell(8);
                cell.setCellStyle(style);
                cell.setCellValue(((MoneyBackInfo) contractSummaryVo.getMoneyBackList().get(0)).getCertificateNumber());
                cell = row.createCell(9);
                cell.setCellStyle(style);
                cell.setCellValue(((MoneyBackInfo) contractSummaryVo.getMoneyBackList().get(0)).getMoney().stripTrailingZeros().toPlainString());

                cell = row.createCell(10);
                cell.setCellStyle(style);
                cell.setCellValue(contractSummaryVo.getMoneySum().stripTrailingZeros().toPlainString());

                cell = row.createCell(11);
                cell.setCellStyle(style);
                cell.setCellValue(contractSummaryVo.getNoOpenMoneySum().stripTrailingZeros().toPlainString());
                cell = row.createCell(12);
                cell.setCellStyle(style);
                cell.setCellValue(contractSummaryVo.getNoMoneySum().stripTrailingZeros().toPlainString());
                cell = row.createCell(13);
                cell.setCellStyle(style);
                cell.setCellValue(contractSummaryVo.getConclusion());
                for (int j = 0; j < a - 1; j++) {
                    rowNum++;
                    row = sheet.createRow(rowNum);
                    cell = row.createCell(0);
                    cell.setCellStyle(style);

                    cell = row.createCell(1);
                    cell.setCellStyle(style);

                    cell = row.createCell(2);
                    cell.setCellStyle(style);

                    cell = row.createCell(3);
                    cell.setCellStyle(style);

                    cell = row.createCell(4);
                    cell.setCellStyle(style);

                    cell = row.createCell(5);
                    cell.setCellStyle(style);

                    cell = row.createCell(6);
                    cell.setCellStyle(style);
                    if (contractSummaryVo.getApplyList().size() > j + 1) {
                        cell.setCellValue(((ApplyInvoiceVo) contractSummaryVo.getApplyList().get(j + 1)).getName());
                    }
                    cell = row.createCell(7);
                    cell.setCellStyle(style);
                    if (contractSummaryVo.getApplyList().size() > j + 1) {
                        cell.setCellValue(((ApplyInvoiceVo) contractSummaryVo.getApplyList().get(j + 1)).getMoney().stripTrailingZeros().toPlainString());
                    }
                    cell = row.createCell(8);
                    cell.setCellStyle(style);
                    if (contractSummaryVo.getMoneyBackList().size() > j + 1) {
                        cell.setCellValue(((MoneyBackInfo) contractSummaryVo.getMoneyBackList().get(j + 1)).getCertificateNumber());
                    }
                    cell = row.createCell(9);
                    cell.setCellStyle(style);
                    if (contractSummaryVo.getMoneyBackList().size() > j + 1) {
                        cell.setCellValue(((MoneyBackInfo) contractSummaryVo.getMoneyBackList().get(j + 1)).getMoney().stripTrailingZeros().toPlainString());
                    }
                    cell = row.createCell(10);
                    cell.setCellStyle(style);
                    cell = row.createCell(11);
                    cell.setCellStyle(style);
                    cell = row.createCell(12);
                    cell.setCellStyle(style);
                    cell = row.createCell(13);
                    cell.setCellStyle(style);
                }
            } else if ((contractSummaryVo.getMoneyBackList().size() != 0) && (contractSummaryVo.getApplyList().size() == 0)) {
                int a = contractSummaryVo.getMoneyBackList().size();
                rowNum++;
                row = sheet.createRow(rowNum);
                cell = row.createCell(0);
                cell.setCellStyle(style);
                cell.setCellValue(contractSummaryVo.getManagerName());

                cell = row.createCell(1);
                cell.setCellStyle(style);
                cell.setCellValue(contractSummaryVo.getContractNum());

                cell = row.createCell(2);
                cell.setCellStyle(style);
                cell.setCellValue(contractSummaryVo.getItemName());

                cell = row.createCell(3);
                cell.setCellStyle(style);
                cell.setCellValue(contractSummaryVo.getCompany());

                cell = row.createCell(4);
                cell.setCellStyle(style);
                cell.setCellValue(contractSummaryVo.getContractMoney().stripTrailingZeros().toPlainString());

                cell = row.createCell(5);
                cell.setCellStyle(style);
                cell.setCellValue(contractSummaryVo.getAdjustment());

                cell = row.createCell(6);
                cell.setCellStyle(style);

                cell = row.createCell(7);
                cell.setCellStyle(style);

                cell = row.createCell(8);
                cell.setCellStyle(style);
                cell.setCellValue(((MoneyBackInfo) contractSummaryVo.getMoneyBackList().get(0)).getCertificateNumber());
                cell = row.createCell(9);
                cell.setCellStyle(style);
                cell.setCellValue(((MoneyBackInfo) contractSummaryVo.getMoneyBackList().get(0)).getMoney().stripTrailingZeros().toPlainString());

                cell = row.createCell(10);
                cell.setCellStyle(style);
                cell.setCellValue(contractSummaryVo.getMoneySum().stripTrailingZeros().toPlainString());

                cell = row.createCell(11);
                cell.setCellStyle(style);
                cell.setCellValue(contractSummaryVo.getNoOpenMoneySum().stripTrailingZeros().toPlainString());
                cell = row.createCell(12);
                cell.setCellStyle(style);
                cell.setCellValue(contractSummaryVo.getNoMoneySum().stripTrailingZeros().toPlainString());
                cell = row.createCell(13);
                cell.setCellStyle(style);
                cell.setCellValue(contractSummaryVo.getConclusion());
                for (int j = 0; j < a - 1; j++) {
                    rowNum++;
                    row = sheet.createRow(rowNum);
                    cell = row.createCell(0);
                    cell.setCellStyle(style);

                    cell = row.createCell(1);
                    cell.setCellStyle(style);

                    cell = row.createCell(2);
                    cell.setCellStyle(style);

                    cell = row.createCell(3);
                    cell.setCellStyle(style);

                    cell = row.createCell(4);
                    cell.setCellStyle(style);

                    cell = row.createCell(5);
                    cell.setCellStyle(style);

                    cell = row.createCell(6);
                    cell.setCellStyle(style);

                    cell = row.createCell(7);
                    cell.setCellStyle(style);

                    cell = row.createCell(8);
                    cell.setCellStyle(style);
                    cell.setCellValue(((MoneyBackInfo) contractSummaryVo.getMoneyBackList().get(j + 1)).getCertificateNumber());

                    cell = row.createCell(9);
                    cell.setCellStyle(style);
                    cell.setCellValue(((MoneyBackInfo) contractSummaryVo.getMoneyBackList().get(j + 1)).getMoney().stripTrailingZeros().toPlainString());

                    cell = row.createCell(10);
                    cell.setCellStyle(style);
                    cell = row.createCell(11);
                    cell.setCellStyle(style);
                    cell = row.createCell(12);
                    cell.setCellStyle(style);
                    cell = row.createCell(13);
                    cell.setCellStyle(style);
                }
            } else if ((contractSummaryVo.getMoneyBackList().size() == 0) && (contractSummaryVo.getApplyList().size() != 0)) {
                int a = contractSummaryVo.getApplyList().size();
                rowNum++;
                row = sheet.createRow(rowNum);
                cell = row.createCell(0);
                cell.setCellStyle(style);
                cell.setCellValue(contractSummaryVo.getManagerName());

                cell = row.createCell(1);
                cell.setCellStyle(style);
                cell.setCellValue(contractSummaryVo.getContractNum());

                cell = row.createCell(2);
                cell.setCellStyle(style);
                cell.setCellValue(contractSummaryVo.getItemName());

                cell = row.createCell(3);
                cell.setCellStyle(style);
                cell.setCellValue(contractSummaryVo.getCompany());

                cell = row.createCell(4);
                cell.setCellStyle(style);
                cell.setCellValue(contractSummaryVo.getContractMoney().stripTrailingZeros().toPlainString());

                cell = row.createCell(5);
                cell.setCellStyle(style);
                cell.setCellValue(contractSummaryVo.getAdjustment());

                cell = row.createCell(6);
                cell.setCellStyle(style);
                cell.setCellValue(((ApplyInvoiceVo) contractSummaryVo.getApplyList().get(0)).getName());

                cell = row.createCell(7);
                cell.setCellStyle(style);
                cell.setCellValue(((ApplyInvoiceVo) contractSummaryVo.getApplyList().get(0)).getMoney().stripTrailingZeros().toPlainString());

                cell = row.createCell(8);
                cell.setCellStyle(style);
                cell = row.createCell(9);
                cell.setCellStyle(style);

                cell = row.createCell(10);
                cell.setCellStyle(style);
                cell.setCellValue(contractSummaryVo.getMoneySum().stripTrailingZeros().toPlainString());

                cell = row.createCell(11);
                cell.setCellStyle(style);
                cell.setCellValue(contractSummaryVo.getNoOpenMoneySum().stripTrailingZeros().toPlainString());
                cell = row.createCell(12);
                cell.setCellStyle(style);
                cell.setCellValue(contractSummaryVo.getNoMoneySum().stripTrailingZeros().toPlainString());
                cell = row.createCell(13);
                cell.setCellStyle(style);
                cell.setCellValue(contractSummaryVo.getConclusion());
                for (int j = 0; j < a - 1; j++) {
                    rowNum++;
                    row = sheet.createRow(rowNum);
                    cell = row.createCell(0);
                    cell.setCellStyle(style);

                    cell = row.createCell(1);
                    cell.setCellStyle(style);

                    cell = row.createCell(2);
                    cell.setCellStyle(style);

                    cell = row.createCell(3);
                    cell.setCellStyle(style);

                    cell = row.createCell(4);
                    cell.setCellStyle(style);

                    cell = row.createCell(5);
                    cell.setCellStyle(style);

                    cell = row.createCell(6);
                    cell.setCellStyle(style);
                    cell.setCellValue(((ApplyInvoiceVo) contractSummaryVo.getApplyList().get(j + 1)).getName());

                    cell = row.createCell(7);
                    cell.setCellStyle(style);
                    cell.setCellValue(((ApplyInvoiceVo) contractSummaryVo.getApplyList().get(j + 1)).getMoney().stripTrailingZeros().toPlainString());

                    cell = row.createCell(8);
                    cell.setCellStyle(style);
                    cell = row.createCell(9);
                    cell.setCellStyle(style);
                    cell = row.createCell(10);
                    cell.setCellStyle(style);
                    cell = row.createCell(11);
                    cell.setCellStyle(style);
                    cell = row.createCell(12);
                    cell.setCellStyle(style);
                    cell = row.createCell(13);
                    cell.setCellStyle(style);
                }
            } else {
                rowNum++;
                row = sheet.createRow(rowNum);
                cell = row.createCell(0);
                cell.setCellStyle(style);
                cell.setCellValue(contractSummaryVo.getManagerName());

                cell = row.createCell(1);
                cell.setCellStyle(style);
                cell.setCellValue(contractSummaryVo.getContractNum());

                cell = row.createCell(2);
                cell.setCellStyle(style);
                cell.setCellValue(contractSummaryVo.getItemName());

                cell = row.createCell(3);
                cell.setCellStyle(style);
                cell.setCellValue(contractSummaryVo.getCompany());

                cell = row.createCell(4);
                cell.setCellStyle(style);
                cell.setCellValue(contractSummaryVo.getContractMoney().stripTrailingZeros().toPlainString());

                cell = row.createCell(5);
                cell.setCellStyle(style);
                cell.setCellValue(contractSummaryVo.getAdjustment());

                cell = row.createCell(6);
                cell.setCellStyle(style);
                cell = row.createCell(7);
                cell.setCellStyle(style);
                cell = row.createCell(8);
                cell.setCellStyle(style);
                cell = row.createCell(9);
                cell.setCellStyle(style);

                cell = row.createCell(10);
                cell.setCellStyle(style);
                cell.setCellValue(contractSummaryVo.getMoneySum().stripTrailingZeros().toPlainString());

                cell = row.createCell(11);
                cell.setCellStyle(style);
                cell.setCellValue(contractSummaryVo.getNoOpenMoneySum().stripTrailingZeros().toPlainString());
                cell = row.createCell(12);
                cell.setCellStyle(style);
                cell.setCellValue(contractSummaryVo.getNoMoneySum().stripTrailingZeros().toPlainString());
                cell = row.createCell(13);
                cell.setCellStyle(style);
                cell.setCellValue(contractSummaryVo.getConclusion());
            }
        }
        rowNum++;
        row = sheet.createRow(rowNum);
        cell = row.createCell(0);
        cell.setCellStyle(style);

        cell = row.createCell(1);
        cell.setCellStyle(style);
        cell.setCellValue("合计");
        BigDecimal bigDecimal = new BigDecimal("0");
        BigDecimal bigDecimal2 = new BigDecimal("0");
        BigDecimal bigDecimal3 = new BigDecimal("0");
        BigDecimal bigDecimal4 = new BigDecimal("0");
        for (int i = 0; i < list.size(); i++) {
            ContractSummaryVo contractSummaryVo = (ContractSummaryVo) list.get(i);
            bigDecimal = bigDecimal.add(contractSummaryVo.getContractMoney());
            bigDecimal2 = bigDecimal2.add(contractSummaryVo.getMoneySum());
            bigDecimal3 = bigDecimal3.add(contractSummaryVo.getNoOpenMoneySum());
            bigDecimal4 = bigDecimal4.add(contractSummaryVo.getNoMoneySum());
        }
        cell = row.createCell(2);
        cell.setCellStyle(style);
        cell = row.createCell(3);
        cell.setCellStyle(style);
        cell = row.createCell(4);
        cell.setCellStyle(style);
        cell.setCellValue(bigDecimal.stripTrailingZeros().toPlainString());
        cell = row.createCell(5);
        cell.setCellStyle(style);
        cell = row.createCell(6);
        cell.setCellStyle(style);
        cell = row.createCell(7);
        cell.setCellStyle(style);
        cell = row.createCell(8);
        cell.setCellStyle(style);
        cell = row.createCell(9);
        cell.setCellStyle(style);
        cell = row.createCell(10);
        cell.setCellStyle(style);
        cell.setCellValue(bigDecimal2.stripTrailingZeros().toPlainString());
        cell = row.createCell(11);
        cell.setCellStyle(style);
        cell.setCellValue(bigDecimal3.stripTrailingZeros().toPlainString());
        cell = row.createCell(12);
        cell.setCellStyle(style);
        cell.setCellValue(bigDecimal4.stripTrailingZeros().toPlainString());
        cell = row.createCell(13);
        cell.setCellStyle(style);

        response.setContentType("application/octet-stream");

        response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode("合同汇总表.xls", "UTF-8"));

        response.flushBuffer();

        workbook.write(response.getOutputStream());
    }

    public static File putBatchFilesInZip(List<String> filePaths, File tempFile) throws IOException {
        ZipOutputStream zos = new ZipOutputStream(tempFile);
        for (String pathFile : filePaths) {
            File inputFile = new File(pathFile);
            try {
                FileInputStream fis = new FileInputStream(inputFile);
                Throwable localThrowable3 = null;
                try {
                    ZipEntry entry = new ZipEntry(inputFile.getName());
                    zos.putNextEntry(entry);

                    int len = 0;
                    byte[] bt = new byte['?'];
                    while ((len = fis.read(bt)) != -1) {
                        zos.write(bt, 0, len);
                    }
                } catch (Throwable localThrowable1) {
                    localThrowable3 = localThrowable1;
                    throw localThrowable1;
                } finally {
                    if (fis != null) {
                        if (localThrowable3 != null) {
                            try {
                                fis.close();
                            } catch (Throwable localThrowable2) {
                                localThrowable3.addSuppressed(localThrowable2);
                            }
                        } else {
                            fis.close();
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException();
            }
        }
        zos.flush();
        zos.close();
        return tempFile;
    }

    public static void mergeCellsHorizontal(XWPFTable table, int row, int fromCell, int toCell) {
        for (int cellIndex = fromCell; cellIndex <= toCell; cellIndex++) {
            XWPFTableCell cell = table.getRow(row).getCell(cellIndex);
            if (cellIndex == fromCell) {
                cell.getCTTc().addNewTcPr().addNewHMerge().setVal(STMerge.RESTART);
            } else {
                cell.getCTTc().addNewTcPr().addNewHMerge().setVal(STMerge.CONTINUE);
            }
        }
    }

    public static void mergeCellsVertically(XWPFTable table, int col, int fromRow, int toRow) {
        for (int rowIndex = fromRow; rowIndex <= toRow; rowIndex++) {
            XWPFTableCell cell = table.getRow(rowIndex).getCell(col);
            //第一个合并单元格用重启合并值设置
            if (rowIndex == fromRow) {
                cell.getCTTc().addNewTcPr().addNewVMerge().setVal(STMerge.RESTART);
            } else {
                //合并第一个单元格的单元被设置为“继续”
                cell.getCTTc().addNewTcPr().addNewVMerge().setVal(STMerge.CONTINUE);
            }
        }
    }
}
