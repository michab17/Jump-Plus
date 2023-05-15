import { userData, changeActiveUser, activeUser, addUser, accountData, addAccount, transactionData, addTransaction } from './userData.js';

const mainPage = document.getElementById("mainPage");
const loginPage = document.getElementById("loginPage");
const registerPage = document.getElementById("registerPage");
const userPage = document.getElementById("userPage");
const depositPage = document.getElementById("depositPage");
const withdrawPage = document.getElementById("withdrawPage");
const transferPage = document.getElementById("transferPage");
const transactionPage = document.getElementById("transactionPage");
const infoPage = document.getElementById("infoPage");
const loginButton = document.getElementById("loginButton");
const registerButton = document.getElementById("registerButton");
const digit1 = document.getElementById("digit1");
const digit2 = document.getElementById("digit2");
const digit3 = document.getElementById("digit3");
const digit4 = document.getElementById("digit4");
const registerDigit1 = document.getElementById("registerDigit1");
const registerDigit2 = document.getElementById("registerDigit2");
const registerDigit3 = document.getElementById("registerDigit3");
const registerDigit4 = document.getElementById("registerDigit4");
const pinNums = document.querySelectorAll(".pinNum");
const registerPinNums = document.querySelectorAll(".registerPinNum");
const accountInfo = document.getElementById("accountInfo");
const transactionInfo = document.getElementById("transactionInfo");
const depositForm = document.getElementById("depositForm");
const withdrawForm = document.getElementById("withdrawForm");
const transferForm = document.getElementById("transferForm");
const backToUserFromInfo = document.getElementById("backToUserFromInfo");
const backToUserFromTransaction = document.getElementById("backToUserFromTransaction");
const logoutButton = document.getElementById("logout");

loginButton.addEventListener("click", () => {
  console.log("the login button was clicked");
  showLogin();
});

registerButton.addEventListener("click", () => {
  console.log("the register button was clicked");
  showRegister();
});

function addHidden(inputClass) {
  if (!inputClass.classList.contains("hidden")) {
    inputClass.classList.add("hidden");
  }
}

function removeHidden(inputClass) {
  if (inputClass.classList.contains("hidden")) {
    inputClass.classList.remove("hidden");
  }
}

function showLogin() {
  addHidden(mainPage);
  addHidden(registerPage);
  addHidden(userPage);
  removeHidden(loginPage);
  addHidden(depositPage);
  addHidden(withdrawPage);
  addHidden(transferPage);
  addHidden(transactionPage);
  addHidden(infoPage);
  // history.pushState("login", "Login", "/login");
}
function showMain() {
  removeHidden(mainPage);
  addHidden(registerPage);
  addHidden(userPage);
  addHidden(loginPage);
  addHidden(depositPage);
  addHidden(withdrawPage);
  addHidden(transferPage);
  addHidden(transactionPage);
  addHidden(infoPage);
  // history.pushState("home", "Home", "/home");
}
function showRegister() {
  addHidden(mainPage);
  removeHidden(registerPage);
  addHidden(userPage);
  addHidden(loginPage);
  addHidden(depositPage);
  addHidden(withdrawPage);
  addHidden(transferPage);
  addHidden(transactionPage);
  addHidden(infoPage);
  // history.pushState("register", "Register", "/register");
}
function showUser() {
  addHidden(mainPage);
  addHidden(registerPage);
  removeHidden(userPage);
  addHidden(loginPage);
  addHidden(depositPage);
  addHidden(withdrawPage);
  addHidden(transferPage);
  addHidden(transactionPage);
  addHidden(infoPage);
  // history.pushState("user", "User", `${activeUser}`);
}
function showDeposit() {
  addHidden(mainPage);
  addHidden(registerPage);
  addHidden(userPage);
  addHidden(loginPage);
  removeHidden(depositPage);
  addHidden(withdrawPage);
  addHidden(transferPage);
  addHidden(transactionPage);
  addHidden(infoPage);
}
function showWithdraw() {
  addHidden(mainPage);
  addHidden(registerPage);
  addHidden(userPage);
  addHidden(loginPage);
  addHidden(depositPage);
  removeHidden(withdrawPage);
  addHidden(transferPage);
  addHidden(transactionPage);
  addHidden(infoPage);
}
function showTransfer() {
  addHidden(mainPage);
  addHidden(registerPage);
  addHidden(userPage);
  addHidden(loginPage);
  addHidden(depositPage);
  addHidden(withdrawPage);
  removeHidden(transferPage);
  addHidden(transactionPage);
  addHidden(infoPage);
}

function showTransaction() {
  addHidden(mainPage);
  addHidden(registerPage);
  addHidden(userPage);
  addHidden(loginPage);
  addHidden(depositPage);
  addHidden(withdrawPage);
  addHidden(transferPage);
  removeHidden(transactionPage);
  addHidden(infoPage);
}

function showInfo() {
  addHidden(mainPage);
  addHidden(registerPage);
  addHidden(userPage);
  addHidden(loginPage);
  addHidden(depositPage);
  addHidden(withdrawPage);
  addHidden(transferPage);
  addHidden(transactionPage);
  removeHidden(infoPage);
}

pinNums.forEach((button) => {
  button.addEventListener("click", () => {
    const value = button.value;
    console.log(value);
    if (!digit1.value) {
      digit1.value = value;
    } else if (!digit2.value) {
      digit2.value = value;
    } else if (!digit3.value) {
      digit3.value = value;
    } else if (!digit4.value) {
      digit4.value = value;
    }
  });
});

registerPinNums.forEach((button) => {
  button.addEventListener("click", () => {
    const value = button.value;
    console.log(value);
    if (!registerDigit1.value) {
      registerDigit1.value = value;
    } else if (!registerDigit2.value) {
      registerDigit2.value = value;
    } else if (!registerDigit3.value) {
      registerDigit3.value = value;
    } else if (!registerDigit4.value) {
      registerDigit4.value = value;
    }
  });
});

const loginForm = document.querySelector("#login-form");
const registerForm = document.querySelector("#register-form");

loginForm.addEventListener("submit", function (event) {
  event.preventDefault();

  const usernameInput = document.getElementById("username");
  const pinInputs = document.querySelectorAll("#pinpad input[type='password']");

  const username = usernameInput.value;
  const pin = Array.from(pinInputs)
    .map((input) => input.value)
    .join("");

  if (username.trim() === "") {
    alert("Please enter a username.");
    loginForm.reset();
  }

  if (pin.length !== 4 || !/^\d+$/.test(pin)) {
    alert("Please enter a valid 4-digit PIN.");
    loginForm.reset();
  }

  if (loginBool(username, pin)) {
    showUser();
  } else {
    alert("Please enter a valid username and pin");
    loginForm.reset();
  }
});

const loginBool = (username, pin) => {
  console.log(userData);
  for (let i = 0; i < userData.length; i++) {
    if (userData[i].username === username && userData[i].pin == pin) {
      changeActiveUser(userData[i]);
      if (activeUser != {}) {
        document.getElementById("userUsername").innerText = activeUser.username;
      }
      return true;
    }
  }
  return false;
};

registerForm.addEventListener("submit", function (event) {
  event.preventDefault();
  // Get references to the username and pin input fields and the form
  const registerUsernameInput = document.getElementById("registerUsername");
  const registerPinInputs = document.querySelectorAll("#registerPinpad input[type='password']");
  const initDepositInput = document.getElementById("initDeposit");
  const accountName = document.getElementById("accountType");
  // Get the values of the username and pin input fields
  const registerUsername = registerUsernameInput.value;
  const registerPin = Array.from(registerPinInputs)
    .map((input) => input.value)
    .join("");
  const initDeposit = initDepositInput.value
  const name = accountName.value

  // Perform validation on the input values
  if (registerUsername.trim() === "") {
    alert("Please enter a username.");
    registerForm.reset();
  }

  if (registerPin.length !== 4 || !/^\d+$/.test(registerPin)) {
    alert("Please enter a valid 4-digit PIN.");
    registerForm.reset();
  }
  
  if (initDeposit <= 0) {
    alert("Please enter an initial deposit greater than 0")
    registerForm.reset();
  }

  if (name.trim() === "") {
    alert("Please enter an account name")
    registerForm.reset();
  }

  // If the input values are valid, submit the form
  const usernameList = [];
  userData.forEach((user) => usernameList.push(user.username));
  const nextUserId = userData.length + 1;
  const nextAccountId = accountData.length + 1;
  if (!usernameList.includes(registerUsername)) {
      addUser({id: nextUserId, username: registerUsername, pin: registerPin})
      addAccount({id: nextAccountId, userId: nextUserId, username: registerUsername, name: name, funds: initDeposit})
      console.log(userData)
      showMain();
  } else {
    alert("Username already in use")
    form.reset();
  }
});

logoutButton.addEventListener("click", () => {
  changeActiveUser({});
  loginForm.reset();
  showMain();
});

const depositButton = document.getElementById("depositButton");
const withdrawButton = document.getElementById("withdrawButton");
const transferButton = document.getElementById("transferButton");
const transactionButton = document.getElementById("transactionButton");
const infoButton = document.getElementById("infoButton");

depositButton.addEventListener("click", () => {
  console.log("the deposit button was clicked");
  depositForm.addEventListener("submit", function (event) {
    event.preventDefault();
    const depositInput = document.getElementById("depositInput");
    const accountType = document.getElementById("depositAccountType");
    
    const account = accountType.value;
    const depositAmount = parseFloat(depositInput.value);

    if (depositAmount <= 0) {
      alert("Please enter and amount greater than zero")
      depositForm.reset();
    }
    function checkMatchingAccount(testAccount) {
      return testAccount.name === account;
    }

    const finalAccount = accountData.filter(account => account.userId === activeUser.id).filter(checkMatchingAccount);

    if (finalAccount.length === 0) {
      alert("Matching account not found")
      depositForm.reset();
    } else {
      finalAccount[0].funds += depositAmount;
      const nextTransactionId = transactionData.length + 1;
      addTransaction({id: nextTransactionId, userId: activeUser.id, type: "Deposit", description: `$${depositAmount} was deposited into your ${account} account`})
      showUser();
    }
  })
  showDeposit();
});

withdrawButton.addEventListener("click", () => {
  console.log("the withdraw button was clicked");
  withdrawForm.addEventListener("submit", function (event) {
    event.preventDefault();
    const withdrawInput = document.getElementById("withdrawInput");
    const accountType = document.getElementById("withdrawAccountType");
    
    const account = accountType.value;
    const withdrawAmount = parseFloat(withdrawInput.value);

    if (withdrawAmount <= 0) {
      alert("Please enter and amount greater than zero")
      withdrawForm.reset();
    }
    function checkMatchingAccount(testAccount) {
      return testAccount.name === account;
    }

    const finalAccount = accountData.filter(account => account.userId === activeUser.id).filter(checkMatchingAccount);

    if (finalAccount.length === 0) {
      alert("Matching account not found")
      withdrawForm.reset();
    } else {
      finalAccount[0].funds -= withdrawAmount;
      const nextTransactionId = transactionData.length + 1;
      addTransaction({id: nextTransactionId, userId: activeUser.id, type: "Withdraw", description: `$${withdrawAmount} was withdrawn from your ${account} account`})
      showUser();
    }
  })
  showWithdraw();
});

transferButton.addEventListener("click", () => {
  console.log("the transfer button was clicked");
  transferForm.addEventListener("submit", function (event) {
    event.preventDefault();
    const transferAccountName = document.getElementById("transferAccountName");
    const transferInput = document.getElementById("transferInput");
    const accountToType = document.getElementById("transferToAccountType");
    const accountFromType = document.getElementById("transferFromAccountType");
    
    const accountName = transferAccountName.value;
    const accountTo = accountToType.value;
    const accountFrom = accountFromType.value;
    const transferAmount = parseFloat(transferInput.value);

    const accountToNames = accountData.filter(account => account.username === accountName);

    if (accountToNames.length === 0) {
      alert("No account with that name was found");
      transferForm.reset();
    }

    if (transferAmount <= 0) {
      alert("Please enter and amount greater than zero")
      transferForm.reset();
    }

    function checkMatchingAccountTo(testAccount) {
      return testAccount.name === accountTo;
    }
    function checkMatchingAccountFrom(testAccount) {
      return testAccount.name === accountFrom;
    }

    const finalToAccount = accountData.filter(account => account.username === accountName).filter(checkMatchingAccountTo);
    const finalFromAccount = accountData.filter(account => account.userId === activeUser.id).filter(checkMatchingAccountFrom);

    console.log("Final To Account " + finalToAccount[0].username + " " + finalToAccount[0].name + " " + finalFromAccount[0].funds);
    console.log("Final From Account" + finalFromAccount[0].username + " " + finalFromAccount[0].name + " " + finalFromAccount[0].funds);

    if (finalToAccount.length === 0 || finalFromAccount.length === 0) {
      alert("Matching account not found")
      transferForm.reset();
    } else {
      finalToAccount[0].funds += transferAmount;
      finalFromAccount[0].funds -= transferAmount;
      let nextTransactionId = transactionData.length + 1;
      const transferToAccountId = userData.find(account => account.username === accountName)
      addTransaction({id: nextTransactionId, userId: transferToAccountId.id, type: "Transfer Into", description: `$${transferAmount} was transfered into your ${accountTo} account`})
      nextTransactionId = transactionData.length + 1;
      addTransaction({id: nextTransactionId, userId: activeUser.id, type: "Transfer Out", description: `$${transferAmount} was transfered out of your ${accountFrom} account`})
      showUser();
    }
  })
  showTransfer();
});

transactionButton.addEventListener("click", () => {
  console.log("the transaction button was clicked");
  const transactionList = transactionData.filter(transaction => transaction.userId === activeUser.id).slice(-5);
  for (var i = 4; i >= 0; i--) {
    transactionInfo.innerHTML += `<h4>Transaction #${i + 1}</h4>`
    transactionInfo.innerHTML += `<h5>Name: ${transactionList[i].type}</h5>`
    transactionInfo.innerHTML += `<h5>Available Funds: ${transactionList[i].description}</h5>`
    transactionInfo.innerHTML += `<h5>-------------------------------</h5>`
  }
  showTransaction();
});

backToUserFromTransaction.addEventListener("click", () => {
  console.log("Back Button Clicked");
  showUser();
  transactionInfo.innerHTML = "";
})

infoButton.addEventListener("click", () => {
  const accountList = accountData.filter(account => account.userId === activeUser.id);
  console.log("the info button was clicked");
  document.getElementById("infoUsername").innerText = activeUser.username;
  document.getElementById("infoPin").innerText = activeUser.pin;
  console.log("Active User" + activeUser.id);
  console.log("AccountList" + accountList);

  for (var i = 0; i < accountList.length; i++) {
    
    accountInfo.innerHTML += `<h4>Account #${i + 1}</h4>`
    accountInfo.innerHTML += `<h5>Type: ${accountList[i].name}</h5>`
    accountInfo.innerHTML += `<h5>Available Funds: $${accountList[i].funds}</h5>`
    accountInfo.innerHTML += `<h5>-------------------------------</h5>`
  }
  showInfo();
});

backToUserFromInfo.addEventListener("click", () => {
  console.log("Back Button Clicked");
  showUser();
  accountInfo.innerHTML = "";
})