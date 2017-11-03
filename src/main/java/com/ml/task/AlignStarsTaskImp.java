package com.ml.task;

import org.springframework.stereotype.Component;

@Component("alignStarsTaskImp")
public class AlignStarsTaskImp extends StarsTask {
	
	public AlignStarsTaskImp() {
		super.type = StarsTask.SEQUIA;
	}

	@Override
	protected void execute() {
		double x1 = 500*Math.cos(firstonepos);
		double y1 = 500*Math.sin(firstonepos);
		double x2 = 2000*Math.cos(secondonepos);
		double y2 = 2000*Math.sin(secondonepos);
		double x3 = 1000*Math.cos(thirthdone);
		double y3 = 1000*Math.sin(thirthdone);
		
		double m = (y2-y1)/(x2-x1);
		double a1 = Math.round(y1 - m*x1);
		double a2 = Math.round(y2 - m*x2);
		double a3 = Math.round(y3 - m*x3);	
		
		validate(a1,a2,a3,m);
	}
	
	protected void validate(double a1, double a2, double a3, double m) {
		if ( a1 == a2 && a1 == a3 && a1 == 0 ) {
			System.out.println("[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[" + StarsTask.SEQUIA + "]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]");
			System.out.println("////////////////////");
			System.out.println("Day :"+count);
			System.out.println("firstone pos: "+firstonepos);
			System.out.println("secondone pos: "+secondonepos);
			System.out.println("thirthdone: "+thirthdone);
			System.out.println("m :"+m);
			System.out.println("a1 :"+a1);
			System.out.println("a2 :"+a2);
			System.out.println("a3 :"+a3);
			countSuccess += 1;
			System.out.println("countSequia: "+countSuccess);
			repo.save(getWeather(count, StarsTask.SEQUIA));
		}
	}
}
