import java.util.ArrayList;
import java.util.Objects;
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
//输入A集合元素---------------------------------------------------------
            System.out.println("请输入集合A:(格式为“<,>”)");
            gather = in.nextLine();
            int k = 1;
            for (int i = 1; i < gather.length(); i = i + 1) {
                colEntity data1 = new colEntity();
                if (gather.charAt(i) == ',' || gather.charAt(i) == '>') {
                    data1.setData(gather.substring(k, i));
                    k = i + 1;
                    A.add(data1);
                }
            }
//            for (colEntity entity : A) {      //输出所得到的所有元素
//                System.out.println(entity.getData());
//            }
            k = 1;
            in.reset();
//输入A集合元素---------------------------------------------------------------
            System.out.println("请输入集合B:(格式为“<,>”)");  //输入B集合元素
            gather = in.nextLine();
            for (int i = 1; i < gather.length(); i = i + 1) {
                colEntity data2 = new colEntity();
                if (gather.charAt(i) == ',' || gather.charAt(i) == '>') {
                    data2.setData(gather.substring(k, i));
                    k = i + 1;
                    B.add(data2);
                }
            }
//            for (colEntity colEntity : B) {     //输出所得到的所有元素
//                System.out.println(colEntity.getData());
//            }
            k = 2;
            in.reset();
//输入两集合的一个关系-------------------------------------------------------------------
            System.out.println("请输入A到B的关系:(输入格式为序偶集)");
            gather = in.nextLine();
            for (int i = 1; i < gather.length() - 1; ) {
                if (gather.charAt(i) == '>') {
                    String ch;
                    ch = gather.substring(k, i + 1);  //截取一个一个序偶元素
                    binRelationEntity data = new binRelationEntity();
                    int x = 0;
                    int e;
                    for (e = 0; e < ch.length(); e++) {
                        if (ch.charAt(e) == ',') {
                            data.setOne(ch.substring(x, e));
                            break;
                        }
                    }
                    data.setTwo(ch.substring(e + 1, ch.length() - 1));
                    BR.add(data);
                    i = i + 2;
                    k = i + 1;
                } else
                    i++;
            }
//            for (binRelationEntity binRelationEntity : BR) {  //输出所得到的所有序偶元素
//                System.out.println(binRelationEntity);
//            }
            System.out.print("集合<");
            for (int i = 0; i < A.size() - 1; i++) {
                System.out.print(A.get(i) + ",");
            }
            System.out.print(A.get(A.size() - 1));
            System.out.print(">到<");
            for (int i = 0; i < B.size() - 1; i++) {
                System.out.print(B.get(i) + ",");
            }
            System.out.print(B.get(B.size() - 1));
            System.out.print(">的一个关系是<");
            for (int i = 0; i < BR.size() - 1; i++) {
                System.out.print(BR.get(i) + ",");
            }
            System.out.println(BR.get(BR.size() - 1) + ">");
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

    /**
     * 判断函数 Y:1 N:0
     */
    public boolean JudgeFun() {
        int i;
        for (i = 0; i < A.size(); i++) {
            if (!JudgeBRElement())
                break;
            else if (!JudgeExist(A.get(i).getData(), 1) || !JudgeOnly(A.get(i).getData(), 1))
                break;
        }
        return i == A.size();
    }

    /**
     * 判断入射  Y:1 N:0
     */
    public boolean JudgeIn() {
        for (binRelationEntity binRelationEntity : BR) {
            if (!JudgeOnly(binRelationEntity.getTwo(), 2))
                return false;
        }
        return true;
    }

    /**
     * 判断满射  Y:1 N:0
     */
    public boolean JudgeSu() {
        for (colEntity colEntity : B) {
            if (!JudgeExist(colEntity.getData(), 2))
                return false;
        }
        return true;
    }

    /**
     * 判断元素在BR中是否都存在  Y:1 N:0
     *
     * @param element The element to judge
     * @param col A verdict flag for the collection type
     */
    public boolean JudgeExist(String element, int col) {
        int j;
        if (col == 1) {
            for (j = 0; j < BR.size(); j++) {
                if (Objects.equals(element, BR.get(j).getOne()))
                    break;
            }
        } else {
            for (j = 0; j < BR.size(); j++) {
                if (Objects.equals(element, BR.get(j).getTwo()))
                    break;
            }
        }
        return j != BR.size();
    }

    /**
     * 判断输入的序偶集中元素是否都在A，B集合中  Y:1 N:0
     */
    public boolean JudgeBRElement()
    {
        boolean flag = true;
        int j, i;
        for (j = 0; j < BR.size(); j++) {
            for (i = 0; i < A.size(); i++) {
                if (Objects.equals(BR.get(j).getOne(), A.get(i).getData()))
                    break;
            }
            if (i == A.size()) {
                flag = false;
                break;
            }
            for (i = 0; i < B.size(); i++) {
                if (Objects.equals(BR.get(j).getTwo(), B.get(i).getData()))
                    break;
            }
            if (i == B.size()) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    /**
     * 判断元素在BR中是否唯一  Y:1 N:0
     *
     * @param element The element to judge
     * @param col A verdict flag for the collection type
     */
    public boolean JudgeOnly(String element, int col) {
        int j, k = 0;
        if (col == 1) {
            for (j = 0; j < BR.size(); j++) {
                if (Objects.equals(element, BR.get(j).getOne()))
                    k++;
            }
        } else {
            for (j = 0; j < BR.size(); j++) {
                if (Objects.equals(element, BR.get(j).getTwo()))
                    k++;
            }
        }
        return k == 1 || k == 0;
    }
}