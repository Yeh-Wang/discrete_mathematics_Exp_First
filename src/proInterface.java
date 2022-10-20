import java.util.ArrayList;
import java.util.Scanner;

public class proInterface {
    public void showPanel(){
        Scanner in= new Scanner(System.in);
        ArrayList<colEntity> A = new ArrayList<>();  //A集合
        ArrayList<colEntity> B = new ArrayList<>();  //B集合
        ArrayList<binRelationEntity> BR = new ArrayList<>(); //A->B的关系
        String gather;
        System.out.println("请输入集合A:(格式为“<,>");
        gather=in.nextLine();
        for(int i=1;i<gather.length();i=i+2)
        {
            colEntity data1 =new colEntity();
            data1.setData(Integer.parseInt(gather.substring(i,i+1)));
            A.add(data1);
        }
        in.reset();
        System.out.println("请输入集合B:(格式为“<,>");
        gather=in.nextLine();
        for(int i=1;i<gather.length();i=i+2)
        {
            colEntity data2 =new colEntity();
            data2.setData(Integer.parseInt(gather.substring(i,i+1)));
            B.add(data2);
        }
        System.out.println(B.get(0));
        in.reset();
        System.out.println("请输入A到B的关系:(输入格式为序偶集)");
        gather=in.nextLine();
        for(int i=2;i<gather.length();i=i+6)
        {
            binRelationEntity data =new binRelationEntity();
            data.setOne(Integer.parseInt(gather.substring(i,i+1)));
            data.setTwo(Integer.parseInt(gather.substring(i+2,i+3)));
            BR.add(data);
        }
        System.out.println("<"+BR.get(0)+">");
    }
}
