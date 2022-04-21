const form = document.getElementById('form');
// const username = document.getElementById('username');
const email = document.getElementById('username');
const password = document.getElementById('password');
// const password2 = document.getElementById('password2');

form.addEventListener('submit', e => {
    // check value of validateInputs in log
    console.log(validateInputs())
    // value of validate inputs will be 0-2
    if(validateInputs() == 2) {
        validateInputs();
    } else {
        e.preventDefault();
    }

})

const setError = (element, message) => {
    const inputControl = element.parentElement;
    const errorDisplay = inputControl.querySelector('.error');

    errorDisplay.innerText = message;
    inputControl.classList.add('error');
    inputControl.classList.remove('success');
}

const setSuccess = element => {
    const inputControl = element.parentElement;
    const errorDisplay = inputControl.querySelector('.error');

    errorDisplay.innerText = '';
    inputControl.classList.add('success');
    inputControl.classList.remove('error');
};

const isValidEmail = email => {
    const reg = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;

    return reg.test(String(email).toLowerCase());
}

const validateInputs = () => {
    const emailValue = email.value.trim();
    const passwordValue = password.value.trim();
    let emailCheck = false;
    let passCheck = false;

    if(emailValue === '') {
        setError(email, 'Email cannot be blank');
    } else if(!isValidEmail(emailValue)) {
        setError(email, 'Email is not valid');
    } else {
        setSuccess(email);
        emailCheck = true;
    }
    // for password
    if(passwordValue === '') {
        setError(password, 'Password cannot be blank');
    } else if(passwordValue.length <8) {
        setError(password, 'Password must be at least 8 characters');
    } else {
        setSuccess(password);
        passCheck = true
    }
    // return added value of the checks, converts boolean to number
    return emailCheck + passCheck;
}