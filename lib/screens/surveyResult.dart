import 'package:flutter/material.dart';

class SurveyResultScreen extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Survey Result'),
      ),
      body: Center(
        child: Text(
          'Survey Result',
          style: TextStyle(fontSize: 24),
        ),
      ),
    );
  }
}