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
		
		// '������ ū ����'(��������) 
		bool operator <(Student &student) {
			return this->score > student.score;
		}
};

//bool compare(int a, int b) {
//	return a>b;
//}

int main (void) {
	Student students[] = {
		Student("������", 90),
		Student("������", 84),
		Student("������", 92),
		Student("�ڰǿ�", 100),
		Student("������", 68),
	};
	
	sort(students, students+5);
	for(int i=0; i<5; i++) {
		cout << students[i].name << endl;
	}
}
