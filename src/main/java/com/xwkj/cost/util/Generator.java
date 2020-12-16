package com.xwkj.cost.util;

import org.mybatis.generator.api.ShellRunner;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 自动生成 主类
 * 配合MyCommentGenerator使用
 * @author 张永辉
 */
public class Generator {
	public static void main( String[] args ) throws IOException{
        Generator.work();
    }
     
    public static void work() throws IOException {
        String[] args = new String[] { "-configfile", "src\\main\\resources\\generatorConfig.xml", "-overwrite" };
        ShellRunner.main(args);
        String beanPath=getRootPath()+"src/main/java/com/xwkj/cost/model";
        File filedir=new File(beanPath);
        File files[]=filedir.listFiles();
        System.out.println(filedir);
        System.out.println(files);
        for (File file : files) {
            handleSetTransVoidToClass(file);
        }
    }
    public static String handleSetTransVoidToClass(File file) throws IOException{
        if (!file.isDirectory()) {
            String tmp="";
            FileReader fr=new FileReader(file);
            BufferedReader br=new BufferedReader(fr);
            String str;
            while ((str = br.readLine()) != null) {
                tmp=tmp+str+"\r\n";
            }
            //找到类名
            String className=tmp.substring(tmp.indexOf("class")+5+1, tmp.indexOf("{")-1);
            //先切开
            String ss[]=tmp.split("set");
            List<String> litmp=new ArrayList<String>();//容器备用，之所用用它是因为它是变长的
            //如果不满足这个条件，说明找错了，那么就将相邻的两个合并
            for (int i=0;i<ss.length-1;i++) {
                /*条件1：切了之后最后一个字符是空格
                 *条件2：最后一个字符之前的四个字符是“void”
                 *如果满足上面两个条件，说明我们找到了，将其处理好,然后放入容器
                 *如果不满足上面两个条件，就将它与之后的一个合并，并放入容器
                 */
                String s=ss[i];
                String snext=ss[i+1];
                if (s.substring(s.length()-1, s.length()).equals(" ") && s.substring(s.length()-1-4, s.length()-1).equals("void")) {
                    //开始处理
                    String a1=s.substring(0, s.length()-5)+className+" ";
                    ss[i+1]=snext.substring(0, snext.indexOf(";"))+";\r\n        return this;"+snext.substring(snext.indexOf(";")+1, snext.length());
                    litmp.add(a1);
                }else{
                    litmp.add(s);
                }
            }
            litmp.add(ss[ss.length-1]);
            String result="";
            for (String s : litmp) {
                result=result+s+"set";
            }
            result=result.substring(0, result.length()-3);
            PrintWriter out=new PrintWriter(file);
            out.write(result);
            //-关闭流-
            fr.close();
            br.close();
            out.flush();
            out.close();
        }
        return "修改成功";
    }

    /**
     * 得到项目根路径
     * 比如：E:/Workspaces/eclipse/mybatis-zs-tool/
     * @return
     */
    public static String getRootPath(){
        String str=Generator.class.getResource("/").getFile().toString().substring(1);
        System.out.println("str="+str);
        String rootPath=str.replaceAll("target/classes/", "");
        return rootPath;
    }
}
