// Copyright 2020 The Flutter team. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

import 'package:flutter/material.dart';
import 'home.dart';
import 'signup.dart';
import 'package:http/http.dart' as http;
import 'dart:convert';

//로그인 페이지 -아이디 입력, 비밀번호 입력, 회원가입 버튼

class LoginP extends StatefulWidget {
  const LoginP({super.key}); 

  @override
  State<StatefulWidget> createState() => _LoginPState();
}
//로그인 입력을 받음
class _LoginPState extends State<LoginP> {

   /*TextEditingController emailController = TextEditingController();
  TextEditingController passwordController = TextEditingController();

  Future<void> _login() async {
    final String email = emailController.text;
    final String password = passwordController.text;

  Service service = Service();*/

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.white,
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          crossAxisAlignment: CrossAxisAlignment.stretch,
          children: [
            Center(
              child: Image.asset(
                'assets/flirting_icon2.jpg', // 이미지 경로
                height: 100,
              ),
            ),
            SizedBox(height: 40),
            TextField(
              decoration: InputDecoration(
                labelText: '아이디',
                border: OutlineInputBorder(),
              ),
            ),
            SizedBox(height: 16),
            TextField(
              decoration: InputDecoration(
                labelText: '비밀번호',
                border: OutlineInputBorder(),
              ),
              obscureText: true, // 비밀번호 입력을 위해 텍스트 가리기
            ),
            SizedBox(height: 20),
            ElevatedButton(
              onPressed: () {
                Navigator.push(
                context,
                MaterialPageRoute(builder: (context) => HomePage()),
                );// 로그인 버튼 동작
              },
              style: ElevatedButton.styleFrom(
                backgroundColor: Color(0XFF561689),
                padding: EdgeInsets.symmetric(vertical: 15),
              ),
              child: Text('로그인',
              style: TextStyle(
                color: Colors.white,
                  ),),
            ),
            SizedBox(height: 10),
            ElevatedButton(
              onPressed: () {
                Navigator.push(
                  context,
                  MaterialPageRoute(builder: (context) => SignupP()),
                );// 회원가입 버튼 동작
              },
              style: ElevatedButton.styleFrom(
                backgroundColor: Color(0XFF561689),
                padding: EdgeInsets.symmetric(vertical: 15),
              ),
              child: Text(
                '회원가입',
                style: TextStyle(
                color: Colors.white,
                  ),),              
            ),
            SizedBox(height: 20),
            Center(
              child: TextButton(
                onPressed: () {
                  // 비밀번호 찾기 동작
                },
                child: Text(
                  '비밀번호 찾기',
                  style: TextStyle(
                    color: Colors.black,
                  ),
                ),
              ),
            ),
          ],
        ),
      ),
    );
  }
}