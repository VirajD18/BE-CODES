pragma solidity^0.6.0;

contract studentmanager{
    
    struct Student{
        uint stud_id;
        string name;
        string department;
    }

    Student[] students;

    function add_student(uint stud_id, string memory name, string memory department) public{
        Student memory stud = Student(stud_id, name, department);
        students.push(stud);
    }

    function get_student(uint stud_id) public view returns(string memory, string memory){
        for (uint i =0; i<students.length; i++){
            Student memory stud = students[i];
            if(stud.stud_id == stud_id){
                return (stud.name, stud.department);
            }
        }
    }

}
