package S1;
public class S2{
    public static void main(String[] args) {
        print30Questions();
    }
    private static void print30Questions() {
        //˵������ӡ30���⺯�����ѽ��յ�����Ŀ�ַ�������ָ����ʽ�����
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
        //˵����getQuestion()�õ���Ŀ���������������Ŀ��������Ŀ�ַ�����
        int t = 0;
        String strz = "";    
        int x=1+(int)(Math.random()*100);        
        int y=1+(int)(Math.random()*100);    
        int z=1+(int)(Math.random()*100);
        if( z<=25 ) {
            strz = "��";
            x = x % 10;
            y = y % 10;//������λ�����
        }
        if( z>25 && z<=50 ) {
            strz = "��";
            y = ( y % 10 ) + 1;//��������Ϊ0�ǲ���
        }
        if( z>50 && z<=75) {
            strz = "+";
            if ((x+y) > 100) {        
                x = x / 2;
                y = y / 2;//�˷���ӽ��������100
            }        
        }
        if( z>75 ) {
            strz = "-";
            if( x < y ){
                t = y;
                y = x;
                x = t;//��֤�����Ǵ�����ȥС��
            }
        }            
        String strx = String.valueOf( x );
        String stry = String.valueOf( y );
        String ques = " " + strx + strz + stry + "=";
        if(ques.length()==5)ques = ques + " ";
        if(ques.length()==4)ques = ques + "  ";
        if(ques.length()==3)ques = ques + "   ";//���ָ�ʽ
        return ques;
    }//getQuestion

}
