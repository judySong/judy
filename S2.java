package S1;
public class S2{
    public static void main(String[] args) {
        print30Questions();
    }
    private static void print30Questions() {
        //说明：打印30道题函数，把接收到的题目字符串按照指定格式输出。
        for (int i = 0; i < 10; i++) {
            System.out.print( i+1 );
            System.out.print("." + getPfQuestion() + "    ");
            System.out.print( i+11 );
            System.out.print("." + getPfQuestion() + "    ");
            System.out.print( i+21 );
            System.out.println("." + getPfQuestion());
        }
    }
        private static String getPfQuestion() {
        //说明：getPfQuestion()得到真分数题目函数，随机生成真分数题目，返回真分数题目字符串。
        int t = 0;
        String strz = "";    
        
        int x1=1+(int)(Math.random()*10);
        int x2=1+(int)(Math.random()*10);//分母
        
        int y1=1+(int)(Math.random()*10);
        int y2=1+(int)(Math.random()*10);//分母
        
        if( x2 <= x1 ){
            t = x2;
            x2 = x1;
            x1 = t;
            if( x1 == x2 ) {
                x1 = x1 - 1;//保证分子比分母小
            }
        }
        
        if( y2 <= y1 ){
            t = y2;
            y2 = y1;
            y1 = t;
            if( y1 == y2 ) {
                y1 = y1 - 1;//保证分子比分母小
            }
        }
        
        int z=1+(int)(Math.random()*100);
        
        if( z<=25 ) {
            strz = "×";
        }
        if( z>25 && z<=50 ) {
            strz = "÷";
            if( y1 == 0 )
            y1 = y1 + 1;//除数的分子不能为0是不是
        }
        if( z>50 && z<=75) {
            strz = "+";    
        }
        if( z>75 ) {
            strz = "-";
            if( x1/x2 > y1/y2 ) {
                
                t = x1;
                x1 = y1;
                y1 = t;
                
                t = x2;
                x2 = y2;
                y2 = t;//保证减法是大数减去小数
            }
        }            
        
        String strx1 = String.valueOf( x1 );
        String strx2 = String.valueOf( x2 );
        String stry1 = String.valueOf( y1 );
        String stry2 = String.valueOf( y2 );

        String ques = " " + strx1 + "/" + strx2 + strz + stry1 + "/" + stry2 + "=";
            
        return ques;
    }//getPfQuestion

}
