package lesson35.spring.basics.part2.component;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

/**
 * @author spasko
 */
@Component
@DependsOn("pig")
public class Tiger {
	private Pig pig = new Pig() {
		@Override
		public String getVoice() {
			return "Pig never died!!!";
		}
	};
	private String voice;

	public Tiger() {
	}

	@Autowired
	public Tiger(Pig pig) {
		this.pig = pig;
	}

	public void setVoice(String voice) {
		this.voice = voice;
	}

	public String getVoice() {
		return voice;
	}

	public String toString() {
		return "Tiger say " + getVoice()
				+ (Objects.nonNull(pig) ? " and very like animal that said:" + pig.getVoice() : "");
	}
}
