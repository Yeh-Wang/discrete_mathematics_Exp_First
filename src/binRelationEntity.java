public class binRelationEntity {  //创建实体存储序偶集(relation)
    private String pr;
    private String one;
    private String sep;
    private String two;
    private String re;
    public binRelationEntity() {pr="<";one="";sep=",";two="";re=">";}
    public String getOne() {return one;}
    public void setOne(String one) {this.one = one;}
    public String getTwo() {return two;}
    public void setTwo(String two) {this.two = two;}

    public String toString()
    {
        return pr + one + sep + two + re;
    }
}
