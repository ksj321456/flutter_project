import 'package:flutter/material.dart';
import 'package:flutting_workout/screens/routine.dart';

class HomePage extends StatefulWidget {
  const HomePage({Key? key}) : super(key: key);

  @override
  State<StatefulWidget> createState() => _HomePageState();
}

class _HomePageState extends State<HomePage> {

  final List<Map<String, String>> categories = [
    {'title': '운동 루틴 관리'},
    {'title': '기구 사용안내'},
    {'title': '내 주변 헬스장'},
    {'title': '나의 운동 기록'},
  ];

void _onCategoryTap({String category=''}) {
    setState(() {
    });
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
        title: const Text('', style: 
        TextStyle(fontSize: 20, color: Color.fromARGB(255, 255, 255, 255),)),
        backgroundColor: Theme.of(context).colorScheme.primary,
      ),
      drawer: Drawer(
        child: ListView(
          padding: EdgeInsets.zero,
          children: <Widget>[
            const DrawerHeader(
              decoration: BoxDecoration(
                color: Colors.white,
                image: DecorationImage(
                  image: AssetImage(''),
                )  
              ),
              child: Column(
                children: [
                  Padding(padding: EdgeInsets.only(top: 80)),
                  Text('메뉴', 
                      style: TextStyle(color: Colors.black),),
                ],
              ),
            ),
            ...categories.map((category)=> ListTile(
              title: Text(category['title']!),
              onTap: () {
                Navigator.push(context, 
                  MaterialPageRoute(builder: (context) => RoutinePage()));;
                _onCategoryTap(category: category['title']!);
                }
            )),  
          ],
        )
      ),

      bottomNavigationBar: BottomNavigationBar(items: [
        BottomNavigationBarItem(icon: Icon(Icons.home), label: '홈'),
        const BottomNavigationBarItem(icon: Icon(Icons.search), label: '커뮤니티'),
        const BottomNavigationBarItem(icon: Icon(Icons.settings), label: 'MY'),
      ],
      ),
    )
    );    
  }

  _onNavItemTap(int value, BuildContext context) {
    switch (value) {
      case 0:
      //커뮤니티 페이지로 이동
      break;
    }
  }
}