package com.ml.task;

import org.springframework.stereotype.Component;

@Component("alignStarsWithSunTask")
public class AlignStarsWithSunTask extends AlignStarsTaskImp {
	
	public AlignStarsWithSunTask() {
		super.type = StarsTask.PRESION_TEMP_OPTIMA;
	}
	
	@Override
	protected void validate(double a1, double a2, double a3, double m) {
		if( a1 == a2 && a1 == a3 && a1 != 0)
		{
			System.out.println("[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[["+ StarsTask.PRESION_TEMP_OPTIMA +"]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]");
			System.out.println("////////////////////");
			System.out.println("Day :"+count);
			System.out.println("firstone :"+firstonepos);
			System.out.println("secondone :"+secondonepos);
			System.out.println("thirthdone pos:"+thirthdone);
			repo.save(getWeather(count, StarsTask.PRESION_TEMP_OPTIMA));
		}
	}
}
