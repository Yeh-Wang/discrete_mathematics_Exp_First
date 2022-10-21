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
            System.out.println("请输入集合A:(格式为“<,>");   //输入A集合元素
            gather = in.nextLine();
            for (int i = 1; i < gather.length(); i = i + 2) {
                colEntity data1 = new colEntity();
                data1.setData(gather.charAt(i));
                A.add(data1);
            }
            in.reset();
            System.out.println("请输入集合B:(格式为“<,>");  //输入B集合元素
            gather = in.nextLine();
            for (int i = 1; i < gather.length(); i = i + 2) {
                colEntity data2 = new colEntity();
                data2.setData(gather.charAt(i));
                B.add(data2);
            }
            in.reset();
            System.out.println("请输入A到B的关系:(输入格式为序偶集)");  //输入两集合的一个关系
            gather = in.nextLine();
            for (int i = 2; i < gather.length(); i = i + 6) {
                binRelationEntity data = new binRelationEntity();
                data.setOne(gather.charAt(i));
                data.setTwo(gather.charAt(i+2));
                BR.add(data);
            }

            System.out.print("集合<");
            for(int i=0;i<A.size()-1;i++)
            {
                System.out.print(A.get(i)+",");
            }
            System.out.print(A.get(A.size()-1));
            System.out.print(">到<");
            for(int i=0;i<B.size()-1;i++)
            {
                System.out.print(B.get(i)+",");
            }
            System.out.print(B.get(B.size()-1));
            System.out.print(">的一个关系是<");
            for(int i=0;i<BR.size()-1;i++)
            {
                System.out.print(BR.get(i)+",");
            }
            System.out.println(BR.get(BR.size()-1)+">");
//判定关系的类型----------------------------------------------
            if (!JudgeFun()) {
                System.out.println("不满足函数定义!");
            } else if (JudgeIn() && JudgeSu())
                System.out.println("此为双射。");
            else if (JudgeIn())
                System.out.println("此为入射。");
            else if (JudgeSu())
                System.out.println("此为满射。");
            else
                System.out.println("既不是入射也不是满射。");

            j++;
            A.clear();
            B.clear();
            BR.clear();
        }
    }

    public boolean JudgeFun() {      //判断函数   Y:1 N:0
        int i = 0;
        for (i = 0; i < A.size(); i++) {
            if (!JudgeExist(A.get(i).getData(),1) || !JudgeOnly(A.get(i).getData(),1))
                break;
        }
        return i == A.size();
    }

    public boolean JudgeIn() {  //判断入射  Y:1 N:0
        for (binRelationEntity binRelationEntity : BR) {
            if (!JudgeOnly(binRelationEntity.getTwo(),2))
                return false;
        }
        return true;
    }

    public boolean JudgeSu() {   //判断满射  Y:1 N:0
        for (colEntity colEntity : B) {
            if (!JudgeExist(colEntity.getData(),2))
                return false;
        }
        return true;
    }

    public boolean JudgeExist(int element,int col) {   //判断元素在BR中是否都存在  Y:1 N:0
        int j = 0;
        if(col==1){
            for (j = 0; j < BR.size(); j++) {
                if (element == BR.get(j).getOne())
                    break;
            }
        }else {
            for (j = 0; j < BR.size(); j++) {
                if (element == BR.get(j).getTwo())
                    break;
            }
        }
        return j != BR.size();
    }

    public boolean JudgeOnly(int element,int col) {  //判断元素在BR中是否唯一  Y:1 N:0
        int j = 0, k = 0;
        if(col==1){
            for (j = 0; j < BR.size(); j++) {
                if (element == BR.get(j).getOne())
                    k++;
            }
        } else {
            for (j = 0; j < BR.size(); j++) {
                if (element == BR.get(j).getTwo())
                    k++;
            }
        }
        return k == 1 || k == 0;
    }
}
