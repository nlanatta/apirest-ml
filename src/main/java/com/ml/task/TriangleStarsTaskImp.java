package com.ml.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ml.repository.WeatherRepository;

@Component
public class TriangleStarsTaskImp extends StarsTask {

	public TriangleStarsTaskImp() {
		super.type = StarsTask.LLUVIA;
	}

	@Override
	protected void execute() {

		double x1 = 500 * Math.cos(firstonepos);
		double y1 = 500 * Math.sin(firstonepos);
		double x2 = 2000 * Math.cos(secondonepos);
		double y2 = 2000 * Math.sin(secondonepos);
		double x3 = 1000 * Math.cos(thirthdone);
		double y3 = 1000 * Math.sin(thirthdone);

		double l1 = 0;
		double l2 = 0;
		double l3 = 0;
		String status = null;
		if (((firstonepos - secondonepos) >= 135 || (firstonepos - secondonepos) <= -135)
				&& ((firstonepos - thirthdone) >= 140 || (firstonepos - thirthdone) <= -140)
				&& ((secondonepos - thirthdone) >= 90 || (thirthdone - secondonepos) >= 90)) {

			l1 = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
			l2 = Math.sqrt(Math.pow((x3 - x1), 2) + Math.pow((y3 - y1), 2));
			l3 = Math.sqrt(Math.pow((x2 - x3), 2) + Math.pow((y2 - y3), 2));

			System.out.println("[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[" + StarsTask.LLUVIA
					+ "]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]");
			System.out.println("////////////////////");
			status = StarsTask.LLUVIA;
			System.out.println("Day :" + count);
			System.out.println("firstone :" + firstonepos);
			System.out.println("secondone :" + secondonepos);
			System.out.println("thirthdone :" + thirthdone);
			countSuccess += 1;
			System.out.println("countLluvia: " + countSuccess);

			repo.save(getWeather(count, status));
		}

	}

}
