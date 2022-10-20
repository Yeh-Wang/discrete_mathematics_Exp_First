import java.util.ArrayList;
import java.util.Scanner;

public class proInterface {
    ArrayList<colEntity> A = new ArrayList<>();  //A集合
    ArrayList<colEntity> B = new ArrayList<>();  //B集合
    ArrayList<binRelationEntity> BR = new ArrayList<>(); //A->B的关系

    public void showPanel() {
        int j = 0;
        while (j < 99) {
            Scanner in = new Scanner(System.in);
            String gather;
            System.out.println("请输入集合A:(格式为“<,>");
            gather = in.nextLine();
            for (int i = 1; i < gather.length(); i = i + 2) {
                colEntity data1 = new colEntity();
                data1.setData(Integer.parseInt(gather.substring(i, i + 1)));
                A.add(data1);
            }
            in.reset();
            System.out.println("请输入集合B:(格式为“<,>");
            gather = in.nextLine();
            for (int i = 1; i < gather.length(); i = i + 2) {
                colEntity data2 = new colEntity();
                data2.setData(Integer.parseInt(gather.substring(i, i + 1)));
                B.add(data2);
            }
            in.reset();
            System.out.println("请输入A到B的关系:(输入格式为序偶集)");
            gather = in.nextLine();
            for (int i = 2; i < gather.length(); i = i + 6) {
                binRelationEntity data = new binRelationEntity();
                data.setOne(Integer.parseInt(gather.substring(i, i + 1)));
                data.setTwo(Integer.parseInt(gather.substring(i + 2, i + 3)));
                BR.add(data);
            }
            j++;
        }
    }

    public boolean JudgeFun() {      //判断函数
        int i=0;
        for(i=0;i<A.size();i++)
        {
            if(!JudgeExist(A.get(i).getData()))
                break;
        }
        return i
    }

    public boolean JudgeExist(int element) {   //判断A中元素在关系中是否都存在
        int i = 0, j = 0;
        for (j = 0; j < BR.size(); j++) {
            if (element == BR.get(j).getOne())
                break;
        }
        return j != BR.size();
    }
}
