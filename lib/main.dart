import 'package:flutter/material.dart';
//import 'package:provider/provider.dart';
import 'package:flutting_workout/screens/login.dart';
//import 'package:flutting_workout/screens/home.dart';
//import 'package:flutting_workout/themes/theme.dart';

void main() {
  runApp(const MaterialApp(
    title: 'Flutting',
    home: MyApp(),
  ));
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});
  @override
  Widget build(BuildContext context) {    
    return Scaffold(
      appBar: AppBar(

      ),
      body: Center(
        child: ElevatedButton(
          child: const Text('시작하기'),
          onPressed: () {
            Navigator.push(
              context,
              MaterialPageRoute(builder: (context) => LoginP()),
            );
          },
        ),
      )
    );
  }
}