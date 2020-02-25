#include <iostream>
#include <algorithm>

using namespace std;

class Student {
	public:
		string name;
		int score;
		
		Student(string name, int score) {
			this->name = name;
			this->score = score;
		}
		
		// 'Á¡¼ö°¡ Å« ¼ø¼­'(³»¸²Â÷¼ø) 
		bool operator <(Student &student) {
			return this->score > student.score;
		}
};

//bool compare(int a, int b) {
//	return a>b;
//}

int main (void) {
	Student students[] = {
		Student("±èÀ±¼º", 90),
		Student("À±ÁöÈñ", 84),
		Student("±¸¸íÈÆ", 92),
		Student("¹Ú°Ç¿ë", 100),
		Student("À±ÀçÇÑ", 68),
	};
	
	sort(students, students+5);
	for(int i=0; i<5; i++) {
		cout << students[i].name << endl;
	}
}
