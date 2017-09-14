package S1;
public class S2{
    public static void main(String[] args) {
        print30Questions();
    }
    private static void print30Questions() {
        //说明：打印30道题函数，把接收到的题目字符串按照指定格式输出。
        for (int i = 0; i < 10; i++) {
            System.out.print( i+1 );
            System.out.print("." + getQuestion() + "    ");
            System.out.print( i+11 );
            System.out.print("." + getQuestion() + "    ");
            System.out.print( i+21 );
            System.out.println("." + getQuestion());
        }
    }
    private static String getQuestion() {
        //说明：getQuestion()得到题目函数，随机生成题目，返回题目字符串。
        int t = 0;
        String strz = "";    
        int x=1+(int)(Math.random()*100);        
        int y=1+(int)(Math.random()*100);    
        int z=1+(int)(Math.random()*100);
        if( z<=25 ) {
            strz = "×";
            x = x % 10;
            y = y % 10;//两个各位数相成
        }
        if( z>25 && z<=50 ) {
            strz = "÷";
            y = ( y % 10 ) + 1;//除数不能为0是不是
        }
        if( z>50 && z<=75) {
            strz = "+";
            if ((x+y) > 100) {        
                x = x / 2;
                y = y / 2;//乘法相加结果不大于100
            }        
        }
        if( z>75 ) {
            strz = "-";
            if( x < y ){
                t = y;
                y = x;
                x = t;//保证减法是大数减去小数
            }
        }            
        String strx = String.valueOf( x );
        String stry = String.valueOf( y );
        String ques = " " + strx + strz + stry + "=";
        if(ques.length()==5)ques = ques + " ";
        if(ques.length()==4)ques = ques + "  ";
        if(ques.length()==3)ques = ques + "   ";//保持格式
        return ques;
    }//getQuestion

}
