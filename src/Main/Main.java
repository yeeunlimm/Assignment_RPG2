package Main;

import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.function.Supplier;

import Character.Archer;
import Character.Boar;
import Character.Dog;
import Character.Dragon;
import Character.Gorani;
import Character.Hero;
import Character.Monster;
import Character.Raccoon;
import Character.Warrior;
import Character.WildCat;
import Character.Wizard;
import Map.Mission;
import Map.PotionStore;
import Map.WeaponStore;

public class Main {
	static final Random RAND = new Random();
	static Mission levelUpMission;

	static Monster spawnMonster(int heroLevel) {
		List<Supplier<Monster>> pool = List.of(Raccoon::new, WildCat::new, Dog::new, Gorani::new, Boar::new,
				Dragon::new);
		return pool.get(RAND.nextInt(pool.size())).get();
	}

	static Mission createMissionByLevel(int lv) {
		if (lv < 3)
			return new Mission("너구리", 3);
		if (lv < 4)
			return new Mission("살쾡이", 3);
		if (lv < 6)
			return new Mission("들개", 4);
		if (lv < 7)
			return new Mission("고라니", 4);
		if (lv < 9)
			return new Mission("멧돼지", 5);
		return new Mission("드래곤", 1);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("****** RPG GAME ******");
		System.out.println("1. 전사");
		System.out.println("2. 마법사");
		System.out.println("3. 궁수");
		System.out.print("직업의 번호를 입력하세요: ");
		int job = in.nextInt();
		in.nextLine();

		Hero hero;
		String jobName = "";
		switch (job) {
		case 1:
			hero = new Warrior();
			jobName = "전사";
			break;
		case 2:
			hero = new Wizard();
			jobName = "마법사";
			break;
		case 3:
			hero = new Archer();
			jobName = "궁수";
			break;
		default:
			hero = new Warrior();
			jobName = "전사";
			break;
		}
		System.out.println(jobName + "가 선택되었습니다.");

		System.out.print("영웅의 이름을 입력하세요: ");
		hero.name = in.nextLine();
		System.out.println("이름이 입력되었습니다.");
		System.out.println("게임에 입장하였습니다.\n");

		PotionStore potionStore = new PotionStore();
		Mission levelUpMission = new Mission("살쾡이", 5);
		hero.setMission(levelUpMission);
		WeaponStore weaponStore = new WeaponStore();
		printHero(hero);

		while (true) {
			System.out.println("************************");
			System.out.println("1. 사냥터 입장");
			System.out.println("2. 포션 상점 입장");
			System.out.println("3. 무기 상점 입장");
			System.out.println("4. 탐험하기");
			System.out.println("0. 게임 종료");
			System.out.print("입장할 장소를 선택하세요: ");
			int sel = in.nextInt();

			if (sel == 1) {
				System.out.println("사냥터에 입장하였습니다.");
				System.out.println("1. 너구리\n2. 살쾡이\n3. 들개\n4. 고라니\n5. 멧돼지\n6. 드래곤");
				System.out.print("전투할 상대를 입력하세요: ");
				int choice = in.nextInt();

				Monster monster;
				switch (choice) {
				case 1:
					monster = new Raccoon();
					break;
				case 2:
					monster = new WildCat();
					break;
				case 3:
					monster = new Dog();
					break;
				case 4:
					monster = new Gorani();
					break;
				case 5:
					monster = new Boar();
					break;
				case 6:
					monster = new Dragon();
					break;
				default:
					monster = new Raccoon();
					break;
				}
				System.out.println(monster.name + "와 전투를 시작합니다.");

				while (hero.hp > 0 && monster.hp > 0) {
					String jobClass = hero.getClass().getSimpleName();
					System.out.println("공격 스킬을 선택하세요:");
					switch (jobClass) {
					case "Warrior" -> System.out.println("1. 쓰러스트 \n2. 펀치 \n3. 불꽃 회전참 \n4. 삼단베기");
					case "Wizard" -> System.out.println("1. 마법 찌르기 \n2. 불덩이 \n3. 천둥 \n4. 운석");
					case "Archer" -> System.out.println("1. 활 찌르기 \n2. 연사 화살 \n3. 폭풍 사격 \n4. 3연타 화살");
					default -> System.out.println("1~4 스킬 중에서 선택");
					}
					System.out.print("1~4 스킬 중 선택하세요: ");
					int skill = in.nextInt();
					int damage = hero.attack(skill);
					monster.attacked(damage, skill, jobClass);

					if (monster.hp > 0) {
						hero.attacked(monster.attack());
					}
				}

				if (monster.hp <= 0) {
					System.out.println(monster.name + " 처치 완료!");
					hero.reportKill(monster.name);
					hero.getMission().progress(monster.name);
					printHero(hero);
					hero.money += 10;
					hero.gainExp(monster.expReward);

					if (hero.getMission().isCompleted()) {
						hero.money += hero.getMission().getRewardGold();
						System.out.println("미션 보상 100원 획득!");

						if (hero.getMission() == levelUpMission) {
							hero.level++;
							System.out.println("특별 미션 완료! 레벨업 ▶︎ Lv." + hero.level);
						}
						Mission next = createMissionByLevel(hero.level);
						hero.setMission(next);
						System.out.println("새 미션: " + nextTarget(next) + " " + nextCnt(next) + "마리!");

					}
				}

			} else if (sel == 2) {
				potionStore.enter(hero);
				printHero(hero);
			} else if (sel == 3) {
				weaponStore.enter(hero);
				printHero(hero);
			} else if (sel == 4) {
				explore(hero, in);
				printHero(hero);
			} else if (sel == 0) {
				System.out.println("게임을 종료합니다.");
				break;
			} else {
				System.out.println("잘못된 입력입니다.");
			}
		}

	}

	static void explore(Hero hero, Scanner in) {
		System.out.println("🌲 숲속 깊은 곳으로 발걸음을 옮깁니다...");

		int event = RAND.nextInt(6);

		switch (event) {
		case 0 -> {
			System.out.println("🎁 오래된 상자를 발견했다!");
			System.out.println("💰 100원을 획득했습니다!");
			hero.money += 100;
		}
		case 1 -> {
			System.out.println("💥 으악! 날카로운 가시에 찔렸습니다!");
			int damage = 15 + RAND.nextInt(10);
			hero.hp = Math.max(1, hero.hp - damage);
			System.out.println("HP -" + damage);
		}
		case 2 -> {
			System.out.println("🪨 이상한 바위를 만졌습니다...");
			hero.defense += 3;
		}
		case 3 -> {
			System.out.println("👻 아무 일도 일어나지 않았다...");
		}
		case 4 -> {
			System.out.println("💤 깊은 잠에 빠졌습니다... HP 회복!");
			int heal = 20 + RAND.nextInt(11);
			hero.hp += heal;
			System.out.println("HP +" + heal);
		}
		case 5 -> {
			if (hero.level >= 5) {
				System.out.println("🔥 고대 무기의 봉인을 풀었습니다!");
				System.out.println("공격력 +10 증가!");
				hero.power += 10;
			} else {
				System.out.println("🔒 이상한 문양이 그려진 문을 발견했지만, 아무 일도 없었다.");
			}
		}

		}
	}

	static void printHero(Hero hero) {
		System.out.println("************************");
		System.out.println("현재 " + hero.name + "의 이름: " + hero.name);
		System.out.println("현재 " + hero.name + "의 레벨: " + hero.level);
		System.out.println("현재 " + hero.name + "의 힘: " + hero.power);
		System.out.println("현재 " + hero.name + "의 방어력: " + hero.defense);
		System.out.println("현재 " + hero.name + "의 HP: " + hero.hp);
		System.out.println("현재 " + hero.name + "의 MP: " + hero.mp);
		System.out.println("현재 " + hero.name + "의 경험치: " + hero.experience);
		System.out.println("현재 " + hero.name + "의 돈: " + hero.money + "원");
		System.out.println("************************");
		Mission m = hero.getMission();
		System.out.println("▶ 미션: " + nextTarget(m) + " " + nextCnt(m) + "마리 중 " + m.getCurrentCount() + "마리 완료");
		System.out.println("************************");
	}

	static String nextTarget(Mission m) {
		try {
			var f = m.getClass().getDeclaredField("targetName");
			f.setAccessible(true);
			return (String) f.get(m);
		} catch (Exception e) {
			return "?";
		}
	}

	static int nextCnt(Mission m) {
		try {
			var f = m.getClass().getDeclaredField("requiredCount");
			f.setAccessible(true);
			return f.getInt(m);
		} catch (Exception e) {
			return 0;
		}
	}

}
