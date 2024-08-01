import 'package:flutter/material.dart';
import 'package:flutter/services.dart'; // Import the services.dart library

class RoutinePage extends StatefulWidget {
  @override
  State<StatefulWidget> createState() => _RoutinePageState();
}

enum Gender { Male, Female }

enum Purpose { LosingWeight, GainingWeight, BuildingMuscle }

class _RoutinePageState extends State<RoutinePage> {
  Gender _gender = Gender.Male;
  Purpose _purpose = Purpose.LosingWeight;
  final _formKey = GlobalKey<FormState>();
  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(title: const Text('사용자 정보 입력')),
        body: Form(
          key: _formKey,
          child: SingleChildScrollView(
            padding: const EdgeInsets.all(32),
            child: AutofillGroup(
              child: Column(
                children: [
                  ...[
                    //성별 입력
                    ListTile(
                      title: Align(
                        alignment: Alignment.centerLeft,
                        child: const Text('당신의 성별은?'),
                      ),
                    ),
                    RadioListTile(
                      title: const Text('남성'),
                      value: Gender.Male,
                      groupValue: _gender,
                      onChanged: (value) {
                        setState(() {
                          _gender = value!;
                        });
                      },
                    ),
                    RadioListTile(
                      title: const Text('여성'),
                      value: Gender.Female,
                      groupValue: _gender,
                      onChanged: (value) {
                        setState(() {
                          _gender = value!;
                        });
                      },
                    ),
                    //나이 입력
                    TextFormField(
                      autofocus: true,
                      textInputAction: TextInputAction.next,
                      decoration: const InputDecoration(
                        hintText: '25',
                        labelText: '당신의 현재 나이를 입력해 주세요.',
                      ),
                    ),
                    //현재 몸무게 입력
                    TextFormField(
                      autofocus: true,
                      textInputAction: TextInputAction.next,
                      decoration: const InputDecoration(
                        hintText: '65',
                        labelText: '현재 몸무게를 입력해주세요(kg)',
                      ),
                    ),
                    //목표 몸무게 입력
                    TextFormField(
                      autofocus: true,
                      textInputAction: TextInputAction.next,
                      decoration: const InputDecoration(
                        hintText: '61.2',
                        labelText: '목표 몸무게를 입력해주세요(kg)',
                      ),
                    ),
                    ListTile(
                      title: Align(
                        alignment: Alignment.centerLeft,
                        child: const Text('당신의 운동 목적은 무엇입니까?'),
                      ),
                    ),
                    RadioListTile(
                      title: const Text('체중을 감소시키기 위해서'),
                      value: Purpose.LosingWeight,
                      groupValue: _purpose,
                      onChanged: (value) {
                        setState(() {
                          _purpose = value!;
                        });
                      },
                    ),
                    RadioListTile(
                      title: const Text('체중을 늘리기 위해서'),
                      value: Purpose.GainingWeight,
                      groupValue: _purpose,
                      onChanged: (value) {
                        setState(() {
                          _purpose = value!;
                        });
                      },
                    ),
                    RadioListTile(
                      title: const Text('근육을 키우기 위해서'),
                      value: Purpose.BuildingMuscle,
                      groupValue: _purpose,
                      onChanged: (value) {
                        setState(() {
                          _purpose = value!;
                        });
                      },
                    ),
                    TextButton(
                      onPressed: () {
                        setState(() {
                          if (_purpose == Purpose.LosingWeight) {
                            // LosingWeight에 해당하는 위젯을 호출
                            Navigator.push(
                              context,
                              MaterialPageRoute(
                                  builder: (context) => LosingWeightWidget()),
                            );
                          } else if (_purpose == Purpose.BuildingMuscle) {
                            // BuildingMuscle에 해당하는 위젯을 호출
                            Navigator.push(
                              context,
                              MaterialPageRoute(
                                  builder: (context) => BuildingMuscleWidget()),
                            );
                          } else if (_purpose == Purpose.GainingWeight) {
                            // GainingWeight에 해당하는 위젯을 호출
                            Navigator.push(
                              context,
                              MaterialPageRoute(
                                  builder: (context) => GainingWeightWidget()),
                            );
                          }
                        });
                      },
                      child: const Text('제출'),
                    ),
                  ]
                ],
              ),
            ),
          ),
        ));
  }
}

enum SleepingTime { LessThan5, FiveToSix, SixToSeven, OverSeven }

enum DrinkWater { LessThanOne, OneToTwo, TwoToThree, OverThree }

enum DrinkOrSmoking { Drink, Smoking, Both, None }

enum Meal { LessThanTwo, TwoToThree, ThreeToFour, OverFour }

enum ExercisePerWeek { LessThanOne, OneToTwo, TwoToThree, OverThree }

enum ExerciseTime { LessThanThirty, ThirtyToSixty, SixtyToNinety, OverNinety }

enum ExerciseType { Cardio, Weight, Flexibility, Sports, None }

enum Motivation { Health, Appearance, Stress, Social, etc }

//체중 감소 위젯
class LosingWeightWidget extends StatefulWidget {
  @override
  _LosingWeightWidgetState createState() => _LosingWeightWidgetState();
}

class _LosingWeightWidgetState extends State<LosingWeightWidget> {
  SleepingTime _sleepingTime = SleepingTime.LessThan5;
  DrinkWater _drinkWater = DrinkWater.LessThanOne;
  DrinkOrSmoking _drinkOrSmoking = DrinkOrSmoking.None;
  Meal _meal = Meal.LessThanTwo;
  ExercisePerWeek _exercisePerWeek = ExercisePerWeek.LessThanOne;
  ExerciseTime _exerciseTime = ExerciseTime.LessThanThirty;
  ExerciseType _exerciseType = ExerciseType.None;
  Motivation _motivation = Motivation.Health;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        body: Form(
      child: SingleChildScrollView(
        padding: const EdgeInsets.all(32),
        child: AutofillGroup(
          child: Column(
            children: [
              ...[
                //수면 시간 기록
                ListTile(
                  title: Align(
                    alignment: Alignment.centerLeft,
                    child: const Text('당신은 하루에 몇 시간 정도 수면을 취하시나요?'),
                  ),
                ),
                RadioListTile(
                  title: const Text('5시간 이하'),
                  value: SleepingTime.LessThan5,
                  groupValue: _sleepingTime,
                  onChanged: (value) {
                    setState(() {
                      _sleepingTime = value!;
                    });
                  },
                ),
                RadioListTile(
                  title: const Text('5시간 이상 6시간 이하'),
                  value: SleepingTime.FiveToSix,
                  groupValue: _sleepingTime,
                  onChanged: (value) {
                    setState(() {
                      _sleepingTime = value!;
                    });
                  },
                ),
                RadioListTile(
                  title: const Text('6시간 이상 7시간 이하'),
                  value: SleepingTime.SixToSeven,
                  groupValue: _sleepingTime,
                  onChanged: (value) {
                    setState(() {
                      _sleepingTime = value!;
                    });
                  },
                ),
                RadioListTile(
                  title: const Text('7시간 이상 8시간 이하'),
                  value: SleepingTime.OverSeven,
                  groupValue: _sleepingTime,
                  onChanged: (value) {
                    setState(() {
                      _sleepingTime = value!;
                    });
                  },
                ),
                //하루 물 섭취량
                ListTile(
                  title: Align(
                    alignment: Alignment.centerLeft,
                    child: const Text('당신은 하루 평균 몇 잔의 물을 마시나요?'),
                  ),
                ),
                RadioListTile(
                  title: const Text('1잔 이하'),
                  value: DrinkWater.LessThanOne,
                  groupValue: _drinkWater,
                  onChanged: (value) {
                    setState(() {
                      _drinkWater = value!;
                    });
                  },
                ),
                RadioListTile(
                  title: const Text('1~2잔'),
                  value: DrinkWater.OneToTwo,
                  groupValue: _drinkWater,
                  onChanged: (value) {
                    setState(() {
                      _drinkWater = value!;
                    });
                  },
                ),
                RadioListTile(
                  title: const Text('2~3잔'),
                  value: DrinkWater.TwoToThree,
                  groupValue: _drinkWater,
                  onChanged: (value) {
                    setState(() {
                      _drinkWater = value!;
                    });
                  },
                ),
                RadioListTile(
                  title: const Text('3잔 이상'),
                  value: DrinkWater.OverThree,
                  groupValue: _drinkWater,
                  onChanged: (value) {
                    setState(() {
                      _drinkWater = value!;
                    });
                  },
                ),
                //음주 및 흡연 여부
                ListTile(
                  title: Align(
                    alignment: Alignment.centerLeft,
                    child: const Text('음주 혹은 흡연을 하시나요?'),
                  ),
                ),
                RadioListTile(
                  title: const Text('음주'),
                  value: DrinkOrSmoking.Drink,
                  groupValue: _drinkOrSmoking,
                  onChanged: (value) {
                    setState(() {
                      _drinkOrSmoking = value!;
                    });
                  },
                ),
                RadioListTile(
                  title: const Text('흡연'),
                  value: DrinkOrSmoking.Smoking,
                  groupValue: _drinkOrSmoking,
                  onChanged: (value) {
                    setState(() {
                      _drinkOrSmoking = value!;
                    });
                  },
                ),
                RadioListTile(
                  title: const Text('둘다'),
                  value: DrinkOrSmoking.Both,
                  groupValue: _drinkOrSmoking,
                  onChanged: (value) {
                    setState(() {
                      _drinkOrSmoking = value!;
                    });
                  },
                ),
                RadioListTile(
                  title: const Text('아니요'),
                  value: DrinkOrSmoking.None,
                  groupValue: _drinkOrSmoking,
                  onChanged: (value) {
                    setState(() {
                      _drinkOrSmoking = value!;
                    });
                  },
                ),
                //하루 섭취 식사 횟수
                ListTile(
                  title: Align(
                    alignment: Alignment.centerLeft,
                    child: const Text('하루에 몇 끼 식사를 하시나요?(간식 포함)'),
                  ),
                ),
                RadioListTile(
                  title: const Text('2끼 이하'),
                  value: Meal.LessThanTwo,
                  groupValue: _meal,
                  onChanged: (value) {
                    setState(() {
                      _meal = value!;
                    });
                  },
                ),
                RadioListTile(
                  title: const Text('2~3끼'),
                  value: Meal.TwoToThree,
                  groupValue: _meal,
                  onChanged: (value) {
                    setState(() {
                      _meal = value!;
                    });
                  },
                ),
                RadioListTile(
                  title: const Text('3~4끼'),
                  value: Meal.ThreeToFour,
                  groupValue: _meal,
                  onChanged: (value) {
                    setState(() {
                      _meal = value!;
                    });
                  },
                ),
                RadioListTile(
                  title: const Text('5끼 이상'),
                  value: Meal.OverFour,
                  groupValue: _meal,
                  onChanged: (value) {
                    setState(() {
                      _meal = value!;
                    });
                  },
                ),
                //운동 횟수
                ListTile(
                  title: Align(
                    alignment: Alignment.centerLeft,
                    child: const Text('주간 운동 횟수는 어떻게 되나요?'),
                  ),
                ),
                RadioListTile(
                  title: const Text('1회 이하'),
                  value: ExercisePerWeek.LessThanOne,
                  groupValue: _exercisePerWeek,
                  onChanged: (value) {
                    setState(() {
                      _exercisePerWeek = value!;
                    });
                  },
                ),
                RadioListTile(
                  title: const Text('1~2회'),
                  value: ExercisePerWeek.OneToTwo,
                  groupValue: _exercisePerWeek,
                  onChanged: (value) {
                    setState(() {
                      _exercisePerWeek = value!;
                    });
                  },
                ),
                RadioListTile(
                  title: const Text('2~3회'),
                  value: ExercisePerWeek.TwoToThree,
                  groupValue: _exercisePerWeek,
                  onChanged: (value) {
                    setState(() {
                      _exercisePerWeek = value!;
                    });
                  },
                ),
                RadioListTile(
                  title: const Text('3회 이상'),
                  value: ExercisePerWeek.OverThree,
                  groupValue: _exercisePerWeek,
                  onChanged: (value) {
                    setState(() {
                      _exercisePerWeek = value!;
                    });
                  },
                ),
                //운동 시간
                ListTile(
                  title: Align(
                    alignment: Alignment.centerLeft,
                    child: const Text('하루 평균 운동 시간은 어떻게 되나요?'),
                  ),
                ),
                RadioListTile(
                  title: const Text('30분 이하'),
                  value: ExerciseTime.LessThanThirty,
                  groupValue: _exerciseTime,
                  onChanged: (value) {
                    setState(() {
                      _exerciseTime = value!;
                    });
                  },
                ),
                RadioListTile(
                  title: const Text('30분 ~ 1시간'),
                  value: ExerciseTime.ThirtyToSixty,
                  groupValue: _exerciseTime,
                  onChanged: (value) {
                    setState(() {
                      _exerciseTime = value!;
                    });
                  },
                ),
                RadioListTile(
                  title: const Text('1시간 ~ 1시간 30분'),
                  value: ExerciseTime.SixtyToNinety,
                  groupValue: _exerciseTime,
                  onChanged: (value) {
                    setState(() {
                      _exerciseTime = value!;
                    });
                  },
                ),
                RadioListTile(
                  title: const Text('1시간 30분 이상'),
                  value: ExerciseTime.OverNinety,
                  groupValue: _exerciseTime,
                  onChanged: (value) {
                    setState(() {
                      _exerciseTime = value!;
                    });
                  },
                ),
                //운동 종류
                ListTile(
                  title: Align(
                    alignment: Alignment.centerLeft,
                    child: const Text('주로 어떤 종류의 운동을 하시나요?'),
                  ),
                ),
                RadioListTile(
                  title: const Text('유산소 운동(예: 걷기, 달리기)'),
                  value: ExerciseType.Cardio,
                  groupValue: _exerciseType,
                  onChanged: (value) {
                    setState(() {
                      _exerciseType = value!;
                    });
                  },
                ),
                RadioListTile(
                  title: const Text('근력 운동(예: 웨이트 트레이닝)'),
                  value: ExerciseType.Weight,
                  groupValue: _exerciseType,
                  onChanged: (value) {
                    setState(() {
                      _exerciseType = value!;
                    });
                  },
                ),
                RadioListTile(
                  title: const Text('유연성 운동(예: 요가, 스트레칭)'),
                  value: ExerciseType.Flexibility,
                  groupValue: _exerciseType,
                  onChanged: (value) {
                    setState(() {
                      _exerciseType = value!;
                    });
                  },
                ),
                RadioListTile(
                  title: const Text('스포츠(예: 축구, 농구, 테니스)'),
                  value: ExerciseType.Sports,
                  groupValue: _exerciseType,
                  onChanged: (value) {
                    setState(() {
                      _exerciseType = value!;
                    });
                  },
                ),
                RadioListTile(
                  title: const Text('아니요'),
                  value: ExerciseType.None,
                  groupValue: _exerciseType,
                  onChanged: (value) {
                    setState(() {
                      _exerciseType = value!;
                    });
                  },
                ),
                //운동 동기
                ListTile(
                  title: Align(
                    alignment: Alignment.centerLeft,
                    child: const Text('당신이 운동을 하는 이유는 무엇인가요?'),
                  ),
                ),
                RadioListTile(
                  title: const Text('건강을 위해서'),
                  value: Motivation.Health,
                  groupValue: _motivation,
                  onChanged: (value) {
                    setState(() {
                      _motivation = value!;
                    });
                  },
                ),
                RadioListTile(
                  title: const Text('외모를 위해서'),
                  value: Motivation.Appearance,
                  groupValue: _motivation,
                  onChanged: (value) {
                    setState(() {
                      _motivation = value!;
                    });
                  },
                ),
                RadioListTile(
                  title: const Text('스트레스 해소를 위해서'),
                  value: Motivation.Stress,
                  groupValue: _motivation,
                  onChanged: (value) {
                    setState(() {
                      _motivation = value!;
                    });
                  },
                ),
                RadioListTile(
                  title: const Text('사회적 활동을 위해서'),
                  value: Motivation.Social,
                  groupValue: _motivation,
                  onChanged: (value) {
                    setState(() {
                      _motivation = value!;
                    });
                  },
                ),
                RadioListTile(
                  title: const Text('기타'),
                  value: Motivation.etc,
                  groupValue: _motivation,
                  onChanged: (value) {
                    setState(() {
                      _motivation = value!;
                    });
                  },
                ),
              ]
            ],
          ),
        ),
      ),
    ));
  }
}

class BuildingMuscleWidget extends StatefulWidget {
  @override
  _BuildingMuscleWidgetState createState() => _BuildingMuscleWidgetState();
}

class _BuildingMuscleWidgetState extends State<BuildingMuscleWidget> {
  bool _isCheckedChest = false;
  // bool _isCheckedBack = false;
  // bool _isCheckedShoulder = false;
  // bool _isCheckedArm = false;
  // bool _isCheckedLeg = false;
  // bool _isCheckedCore = false;
  // bool _isCheckedEtc = false;
  @override
  Widget build(BuildContext context) {
    return Scaffold(
        body: Form(
      child: SingleChildScrollView(
        padding: const EdgeInsets.all(32),
        child: AutofillGroup(
          child: Column(
            children: [
              ...[
                //골격근량 기록
                //인바디 상에서 골격근량을 기록하도록 함
                ListTile(
                  title: Align(
                    alignment: Alignment.centerLeft,
                    child: const Text('당신의 현재 골격근량은 얼마인가요?'),
                  ),
                ),
                TextFormField(
                  autofocus: true,
                  textInputAction: TextInputAction.next,
                  decoration: const InputDecoration(
                    hintText: '40',
                    labelText: '인바디 상에서의 골격근량을 입력해 주세요(kg)',
                  ),
                ),
                //목표 골격근량
                ListTile(
                  title: Align(
                    alignment: Alignment.centerLeft,
                    child: const Text('당신의 목표 골격근량은 얼마인가요?'),
                  ),
                ),
                TextFormField(
                  autofocus: true,
                  textInputAction: TextInputAction.next,
                  decoration: const InputDecoration(
                    hintText: '45',
                    labelText: '목표 골격근량을 입력해 주세요(kg)',
                  ),
                ),
                //목표 체지방량
                ListTile(
                  title: Align(
                    alignment: Alignment.centerLeft,
                    child: const Text('당신의 목표 체지방량은 얼마인가요?'),
                  ),
                ),
                TextFormField(
                  autofocus: true,
                  textInputAction: TextInputAction.next,
                  decoration: const InputDecoration(
                    hintText: '15',
                    labelText: '목표 체지방량을 입력해 주세요(%)',
                  ),
                ),
                // 근육 증가 목표 부위
                ListTile(
                  title: Align(
                    alignment: Alignment.centerLeft,
                    child: const Text('근육 증가를 원하는 부위는 어디인가요?'),
                  ),
                ),
                // Row(
                //   Checkbox(value: _isCheckedChest, onChanged: (value){
                //     setState(() {
                //       _isCheckedChest = value!;
                //     });
                //   }),

                // )
              ]
            ],
          ),
        ),
      ),
    ));
  }
}

class GainingWeightWidget extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Building Muscle'),
      ),
      body: Center(
        child: Text('Building Muscle Content'),
      ),
    );
  }
}
