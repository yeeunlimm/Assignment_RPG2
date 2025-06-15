package Map;

import java.util.Scanner;

import Character.Hero;

public class PotionStore {

	Scanner in = new Scanner(System.in);

	public void enter(Hero hero) {
		while (true) {
			System.out.println("포션 상점에 입장하였습니다.");
			System.out.println(
					"1. 힘 증강 포션 (30원)\n2. 방어력 증강 포션 (30원)\n3. 경험치 증강 포션 (100원)\n4. HP 증강 포션 (10원)\n5. MP 증강 포션 (10원)\n0. 나가기");
			System.out.print("원하시는 물건을 입력하세요. : ");
			int num = in.nextInt();

			if (num == 0) {
				System.out.println("상점에서 나갑니다.\n");
				break;
			}

			switch (num) {
			case 1 -> {
				if (hero.money >= 30) {
					hero.power += 3;
					hero.money -= 30;
					System.out.println("힘이 증가했습니다! 남은 돈: " + hero.money + "원\n");
				} else {
					System.out.println("돈이 부족하여 힘 포션을 구매할 수 없습니다.\n");
				}
			}
			case 2 -> {
				if (hero.money >= 30) {
					hero.defense += 3;
					hero.money -= 30;
					System.out.println("방어력이 증가했습니다! 남은 돈: " + hero.money + "원\n");
				} else {
					System.out.println("돈이 부족하여 방어력 포션을 구매할 수 없습니다.\n");
				}
			}
			case 3 -> {
				if (hero.money >= 100) {
					hero.experience += 50;
					hero.money -= 100;
					System.out.println("경험치가 증가했습니다! 남은 돈: " + hero.money + "원\n");
				} else {
					System.out.println("돈이 부족하여 경험치 포션을 구매할 수 없습니다.\n");
				}
			}
			case 4 -> {
				if (hero.money >= 10) {
					hero.hp += 50;
					hero.money -= 10;
					System.out.println("HP가 증가했습니다! 남은 돈: " + hero.money + "원\n");
				} else {
					System.out.println("돈이 부족하여 HP 포션을 구매할 수 없습니다.\n");
				}
			}
			case 5 -> {
				if (hero.money >= 10) {
					hero.mp += 50;
					hero.money -= 10;
					System.out.println("MP가 증가했습니다! 남은 돈: " + hero.money + "원\n");
				} else {
					System.out.println("돈이 부족하여 MP 포션을 구매할 수 없습니다.\n");
				}
			}
			default -> System.out.println("잘못된 입력입니다.\n");
			}
		}
	}
}
