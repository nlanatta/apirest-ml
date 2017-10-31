package com.ml.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParametersIncrementer;
import org.springframework.batch.core.JobParametersValidator;
import org.springframework.stereotype.Component;

@Component
public class TimerTaskImp implements Job {

	private int count;
	private double firstone = 0;
	private double secondone = 0;
	private double thirthdone = 0;
	private double thirthdonepos;
	private int countSuccess = 0;
	private double secondonepos;
	private double firstonepos;
	private double perimetro;


	private void checkSameAngule(int count2) {
		if( count2 >= 3650) {
			System.out.println("[[[[[[[[FINISHED]]]]]]]]]]]]]");
		}
		
		firstone -= 1;
		secondone -= 3;
		thirthdone += 5;
		
		firstonepos = firstone + 360;
		secondonepos = secondone + 360;
		if ( firstonepos >= 360 ) {
			firstonepos = firstonepos - 360;
		}
		if ( secondone >= 360 ) {
			secondone = secondone - 360;
		}
		if ( thirthdone >= 360 ) {
			thirthdone = thirthdone - 360;
		}
		if ( secondone <= -360)
		{
			secondone = secondone + 360;
		}
		if ( firstone <= -360)
		{
			firstone = firstone + 360;
		}
//		System.out.println("////////////////////");
//		System.out.println("firstone :"+firstone);
//		System.out.println("secondone :"+secondone);
//		System.out.println("thirthdone :"+thirthdone);
		
//		alignChequer();
		triangleChequer();
//		checkSameLine();
			
	}

	private void checkSameLine() {
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
		
		
		if( a1 == a2 && a1 == a3 && a1 != 0)
		{
			System.out.println("[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[PRESION y TEMP OPTIMA]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]");
			System.out.println("////////////////////");
			System.out.println("Day :"+count);
			System.out.println("firstone :"+firstonepos);
			System.out.println("secondone :"+secondonepos);
//			System.out.println("thirthdone :"+thirthdone);
			System.out.println("thirthdone pos:"+thirthdone);
		}
		
		if ( a1 == a2 && a1 == a3 && a1 == 0 ) {
			System.out.println("[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[SEQUÍA]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]");
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
		}
	}

	private void triangleChequer() {	
		
		double x1 = 500*Math.cos(firstonepos);
		double y1 = 500*Math.sin(firstonepos);
		double x2 = 2000*Math.cos(secondonepos);
		double y2 = 2000*Math.sin(secondonepos);
		double x3 = 1000*Math.cos(thirthdone);
		double y3 = 1000*Math.sin(thirthdone);
		
		double l1 = 0;
		double l2 = 0;
		double l3 = 0;		
		
		if ( ((firstonepos - secondonepos) >= 135 || (firstonepos - secondonepos) <= -135)
			&& ((firstonepos - thirthdone) >= 140 || (firstonepos - thirthdone) <= -140)
			&& ((secondonepos - thirthdone) >= 90 || (thirthdone - secondonepos) >= 90)
			) {
					
			l1 = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
			l2 = Math.sqrt(Math.pow((x3 - x1), 2) + Math.pow((y3 - y1), 2));
			l3 = Math.sqrt(Math.pow((x2 - x3), 2) + Math.pow((y2 - y3), 2));
			
			perimetro = l1 + l2 + l3;
			System.out.println("perimetro : "+perimetro);
			if(perimetro > 6000){
				System.out.println("[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[INTENSA LLUVIA]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]");
				System.out.println("////////////////////");
			}else {					
			
			System.out.println("[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[LLUVIA]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]");
			System.out.println("////////////////////");
			}
			System.out.println("Day :"+count);
			System.out.println("firstone :"+firstonepos);
			System.out.println("secondone :"+secondonepos);
			System.out.println("thirthdone :"+thirthdone);
			countSuccess += 1;
			System.out.println("countLluvia: "+countSuccess);
		}		
	}

	private void alignChequer() {
		
		if ( (firstone == secondone 
				|| firstone == (secondone + 180)
				|| firstone == (secondone - 180))
				&& (firstone == thirthdone 
						|| firstone == (thirthdone + 180)
						|| firstone == (thirthdone - 180))) {
			System.out.println("[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[SEQUÍA]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]");
			System.out.println("////////////////////");
			System.out.println("Day :"+count);
			System.out.println("firstone :"+firstone);
			System.out.println("secondone :"+secondone);
			System.out.println("thirthdone :"+thirthdone);
			System.out.println("thirthdone pos:"+thirthdonepos);
			countSuccess += 1;
			System.out.println("countSequia: "+countSuccess);
		}		
	}

	@Override
	public void execute(JobExecution arg0) {
		checkSameAngule(count);
		count +=1;
	}

	@Override
	public JobParametersIncrementer getJobParametersIncrementer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JobParametersValidator getJobParametersValidator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isRestartable() {
		// TODO Auto-generated method stub
		return false;
	}

}
