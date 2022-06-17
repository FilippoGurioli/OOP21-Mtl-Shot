package controller;

import java.util.HashMap;
import java.util.Map;

import view.sounds.SoundManager;
import view.sounds.SoundManager.Sounds;

public class SoundsController {
	private Controller controllerReference;
	private Map<Sounds, Cooldown> timers;
	private SoundManager soundManager;

	public SoundsController(final Controller controllerReference) {
		this.controllerReference = controllerReference;
		this.timers = new HashMap<>();
		this.soundManager = new SoundManager();
	}

	public void controllerTick() {
		this.timers.forEach((c, sc) -> { sc.tick(); });
		this.timers.entrySet().removeIf(e -> e.getValue().isCooldownOver());
	}

	public boolean tryToPlaySound(final Sounds soundType) {
		if (!this.timers.containsKey(soundType)) {
			/* Se un suono di tipo soundType non è stato fatto ancora partire, lo fa partire */
			this.timers.put(soundType, new Cooldown(100));	/* Temporal gap between two sounds of the same type */
			//this.soundManager.playSound(soundType);
			System.out.println("Play sound " + soundType.name() + " guh");
			return true;
		}
		return false;
	}
}