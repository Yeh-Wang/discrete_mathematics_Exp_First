public class binRelationEntity {  //创建实体存储序偶集(relation)
    private char pr;
    private int one;
    private char sep;
    private int two;
    private char re;
    public binRelationEntity()
    {
        pr='<';
        one=0;
        sep=',';
        two=0;
        re='>';
    }

    public int getOne() {
        return one;
    }

    public void setOne(int one) {
        this.one = one;
    }

    public int getTwo() {
        return two;
    }

    public void setTwo(int two) {
        this.two = two;
    }
}
