function validateForm() {
    var fname = document.forms["registration"]["fname"].value;
    var lname = document.forms["registration"]["lname"].value;
    var dob = document.forms["registration"]["dob"].value;
  
    // Validate First Name
    if (fname.length < 2 || fname.length > 255 || /\d/.test(fname)) {
      alert("Please enter a valid first name.");
      return false;
    }
  
    // Validate Last Name
    if (lname.length < 2 || lname.length > 255 || /\d/.test(lname)) {
      alert("Please enter a valid last name.");
      return false;
    }
  
    // Validate Date of Birth
    var today = new Date();
    var birthdate = new Date(dob);
    var diff = today.getTime() - birthdate.getTime();
    var age = Math.floor(diff / (1000 * 60 * 60 * 24 * 365));
    if (isNaN(birthdate.getTime()) || dob.length !== 10 || dob[4] !== '/' || dob[7] !== '/' || age < 18) {
      alert("Please enter a valid date of birth (YY/MM/DD) and ensure that you are at least 18 years old.");
      return false;
    }
  }
  