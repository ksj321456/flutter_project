/*import 'path/to/user.dart'; // Replace 'path/to/user.dart' with the actual path to the file containing the 'User' class.
import 'package:flutting_workout/screens/home.dart'; // Import the 'LoginP' class from the 'login.dart' file.


Future<void> saveUser(User user) async {
    try {
      final response = await http.post(
        Uri.parse("http://server-uri/user"),
        headers: <String, String>{
          'Content-Type': 'application/json; charset=UTF-8',
        },
        body: jsonEncode(user.toJson()),
      );
      if (response.statusCode != 201) {
        throw Exception("Failed to send data");
      } else {
        print("User Data sent successfully");
        Get.to(const HomePage());
      }
    } catch (e) {
      print("Failed to send user data: ${e}");
    }
  }*/