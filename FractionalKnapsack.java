import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;
import java.text.DecimalFormat;

class Item{
	double weight;
	double profit;
	double profit_per_unit;
	public Item(double pro,double wt){
		weight=wt;
		profit=pro;
		profit_per_unit=pro/wt;
		}
	}

class FractionalKnapsack{
	
	public static double getMaxProfit(double capacity,double[] weights,double[] profits){
		Item[] items=new Item[weights.length];
		for(int i=0;i<items.length;i++){
			items[i]=new Item(profits[i],weights[i]);	
		}
		
		Arrays.sort(items, new Comparator<Item>(){
            @Override
            public int compare (Item i1, Item i2) {
                return i1.profit_per_unit > i2.profit_per_unit ? -1 : 1;
            }
        });
		double maxProfit=0;
		int i=0;
		for(i=0;i<items.length;i++){
			if(capacity>0 && items[i].weight<= capacity){
				capacity=capacity-items[i].weight;
				maxProfit=maxProfit+items[i].profit;
			}
			else
				break;
		}
			if(capacity>0)
				maxProfit=maxProfit+(items[i].profit * capacity)/items[i].weight;
		return maxProfit;
	}
	
	
	
	public static void main(String args[]){
		Scanner scan= new Scanner(System.in);
		System.out.println("Enter the number of items ");
		int n=scan.nextInt();
		System.out.println("Enter the capacity of knapsack");
		double capacity=scan.nextDouble();
		double[] profits = new double[n];
        double[] weights = new double[n];
        for (int i = 0; i < n; i++) {
			System.out.println("Enter item " + (i+1) + " profit and weight");
            profits[i] = scan.nextDouble();
            weights[i] = scan.nextDouble();
        }
		DecimalFormat df2 = new DecimalFormat(".##");
        System.out.printf(df2.format(getMaxProfit(capacity, weights, profits)));
        scan.close();
	}
	
}