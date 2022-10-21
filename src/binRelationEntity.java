public class binRelationEntity {  //创建实体存储序偶集(relation)
    private String pr;
    private char one;
    private String sep;
    private char two;
    private String re;
    public binRelationEntity() {pr="<";one=0;sep=",";two=0;re=">";}
    public char getOne() {return one;}
    public void setOne(char one) {this.one = one;}
    public char getTwo() {return two;}
    public void setTwo(char two) {this.two = two;}

    public String toString()
    {
        return pr + one + sep + two + re;
    }
}
