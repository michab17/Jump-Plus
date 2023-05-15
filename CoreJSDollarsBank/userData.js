export let activeUser = {};

export function changeActiveUser(user) {
  activeUser = user;
}

export let userData = [
  {id: 1, username: "micha", pin: 1234},
  {id: 2, username: "jen", pin: 1234},
  {id: 3, username: "kevin", pin: 1234}
]

export let accountData = [
  {id: 1, userId: 1, username: "micha", name: "Checking", funds: 2500},
  {id: 2, userId: 1, username: "micha", name: "Saving", funds: 2500},
  {id: 3, userId: 2, username: "jen", name: "Checking", funds: 2500},
  {id: 4, userId: 2, username: "jen", name: "Saving", funds: 2500},
  {id: 5, userId: 3, username: "kevin", name: "Checking", funds: 2500},
  {id: 6, userId: 3, username: "kevin", name: "Saving", funds: 2500}
]

export let transactionData = [
  {id: 1, userId: 1, type: "Deposit", description: "$995 was deposited into your checking account"},
  {id: 2, userId: 1, type: "Deposit", description: "$996 was deposited into your checking account"},
  {id: 3, userId: 1, type: "Deposit", description: "$997 was deposited into your checking account"},
  {id: 4, userId: 1, type: "Deposit", description: "$998 was deposited into your checking account"},
  {id: 5, userId: 1, type: "Deposit", description: "$999 was deposited into your checking account"},
  {id: 6, userId: 1, type: "Deposit", description: "$1000 was deposited into your checking account"},
  {id: 7, userId: 2, type: "Deposit", description: "$995 was deposited into your checking account"},
  {id: 8, userId: 2, type: "Deposit", description: "$996 was deposited into your checking account"},
  {id: 9, userId: 2, type: "Deposit", description: "$997 was deposited into your checking account"},
  {id: 10, userId: 2, type: "Deposit", description: "$998 was deposited into your checking account"},
  {id: 11, userId: 2, type: "Deposit", description: "$999 was deposited into your checking account"},
  {id: 12, userId: 2, type: "Deposit", description: "$1000 was deposited into your checking account"},
  {id: 13, userId: 3, type: "Deposit", description: "$995 was deposited into your checking account"},
  {id: 14, userId: 3, type: "Deposit", description: "$996 was deposited into your checking account"},
  {id: 15, userId: 3, type: "Deposit", description: "$997 was deposited into your checking account"},
  {id: 16, userId: 3, type: "Deposit", description: "$998 was deposited into your checking account"},
  {id: 17, userId: 3, type: "Deposit", description: "$999 was deposited into your checking account"},
  {id: 18, userId: 3, type: "Deposit", description: "$1000 was deposited into your checking account"},
]

export function addUser(user) {
  userData.push(user);
}

export function addAccount(account) {
  accountData.push(account);
}

export function addTransaction(transaction) {
  transactionData.push(transaction);
}