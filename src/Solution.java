import java.util.Objects;
import java.util.Scanner;
class Solution {
    public static void main(String[] args) {
        //失物数据
        BookLost[] lostArray2=new BookLost[100];
        CardLost[] lostArray=new CardLost[100];
        CardLost c1=new CardLost("2022.01.10","中心食堂","C001","白*","20201345");
        CardLost c2=new CardLost("2022.01.15","樱花食堂","C002","邓*","20213222");
        CardLost c3=new CardLost("2021.12.10","中心食堂","C003","李**","20192090");
        CardLost c4=new CardLost("2022.03.02","第三教学楼","C004","王**","20203223");
        CardLost c5=new CardLost("2021.08.20","第四教学楼","C005","高**","20219345");
        CardLost c6=new CardLost("2021.10.03","第三教学楼","C006","黄**","20203246");
        CardLost c7=new CardLost("2021.11.05","中心食堂","C007","祝**","20203046");
        CardLost c8=new CardLost("2022.04.04","樱花食堂","C008","张**","20213986");
        CardLost c9=new CardLost("2022.01.09","第三教学楼","C009","孙**","20183132");
        CardLost c0=new CardLost("2022.01.29","第四教学楼","C010","麻**","20196244");
        BookLost b1=new BookLost("2022.02.06","中心食堂","B001","西行漫记");
        BookLost b2=new BookLost("2021.11.06","樱花食堂","B002","古希腊神话");
        BookLost b3=new BookLost("2022.05.28","第四教学楼","B003","信号与系统");
        BookLost b4=new BookLost("2022.02.06","第四教学楼","B004","高等数学（上）");
        BookLost b5=new BookLost("2021.12.30","中心食堂","B005","算法珠玑");
        lostArray[0]=c1;lostArray[1]=c2;lostArray[2]=c3;lostArray[3]=c4;lostArray[4]=c5;
        lostArray[5]=c6;lostArray[6]=c7;lostArray[7]=c8;lostArray[8]=c9;lostArray[9]=c0;
        lostArray2[10]=b1;lostArray2[11]=b2;lostArray2[12]=b3;lostArray2[13]=b4;lostArray2[14]=b5;

        Lost[] findArray;
        Scanner input=new Scanner(System.in);
        System.out.println("Welcome！this is lost and found system");
        System.out.println("请选择失物类型：学生卡请键入1，书籍请键入0");
        int p=input.nextInt();
        System.out.println("请输入失物地点：例： 食堂/教学楼");
        String charLost=input.next();
        System.out.println("please wait for a minute...\nThe following is the query result:");
        if(p==1) findArray=selectByKeyword(lostArray,charLost);
        else findArray=selectByKeyword(lostArray2,charLost);
        sortLost(findArray);
        if(p==1){
            for (int i=0;i<findArray.length&&findArray[i]!=null;i++) {
                System.out.println("the lost cards:");
                for(int j=0;lostArray[j]!=null;j++){
                    if(Objects.equals(findArray[i].lostNums, lostArray[j].lostNums)){
                        lostArray[j].cardDetail();
                        break;
                    }
                }
            }
        }else{
            for (int i=0;i<findArray.length&&findArray[i]!=null;i++) {
                System.out.println("the lost books:");
                for(int j=0;lostArray[j]!=null;j++){
                    if(Objects.equals(findArray[i].lostNums, lostArray2[j].lostNums)){
                        lostArray2[j].bookDetail();
                        break;
                    }
                }
            }
        }
        System.out.println("------------------------------------");
        System.out.println("查询完毕 感谢使用");
    }

    public static void sortLost(Lost[] lostArray) {
        int size=0;
        for (int i=0;i< lostArray.length&&lostArray[i]!=null;i++){
            size++;
        }
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j <size; j++) {
                if (lostArray[i].lostTime.compareTo(lostArray[j].lostTime) > 0) {
                    Lost t=lostArray[i];
                    lostArray[i]=lostArray[j];
                    lostArray[j]=t;
                }
            }
        }
    }

    public static Lost[] selectByKeyword(Lost[] lostArray, String keyword){
        Lost[] findLost = new Lost[lostArray.length];
        int j=0;
        for (int i=0;i<lostArray.length&&lostArray[i]!=null;i++) {
            if (lostArray[i].lostPlace.contains(keyword)) {
                findLost[j] = lostArray[i];
                j++;
            }
        }
        return findLost;
    }
}
