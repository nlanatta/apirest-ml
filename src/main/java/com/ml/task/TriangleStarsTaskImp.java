package com.ml.task;

import org.springframework.stereotype.Component;

@Component
public class TriangleStarsTaskImp extends StarsTask {

	public TriangleStarsTaskImp() {
		super.type = StarsTask.LLUVIA;
	}

	@Override
	protected void execute() {
		String status = null;
		if (((firstonepos - secondonepos) >= 135 || (firstonepos - secondonepos) <= -135)
				&& ((firstonepos - thirthdone) >= 140 || (firstonepos - thirthdone) <= -140)
				&& ((secondonepos - thirthdone) >= 90 || (thirthdone - secondonepos) >= 90)) {

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
