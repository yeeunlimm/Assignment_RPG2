package Map;

public class Mission {
	private String targetName;
	private int requiredCount;
	private int currentCount;
	private boolean completed;

	public Mission(String targetName, int requiredCount) {
		this.targetName = targetName;
		this.requiredCount = requiredCount;
		this.currentCount = 0;
		this.completed = false;
	}

	public void progress(String monsterName) {
		if (!completed && monsterName.equals(targetName)) {
			currentCount++;
			System.out.printf("미션 진행: %s 처치 %d/%d\n", targetName, currentCount, requiredCount);
			if (currentCount >= requiredCount) {
				completed = true;
				System.out.println("미션 완료! 보상으로 추가 골드를 획득합니다.");
			}
		}
	}

	public boolean isCompleted() {
		return completed;
	}

	public int getRewardGold() {
		return completed ? 100 : 0;
	}

	public int getCurrentCount() {
		return currentCount;
	}
}
