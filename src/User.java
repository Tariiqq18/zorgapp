class User {
    String userName;
  private  int userID;
  private UserRoles role;

    public User(int UserID, String userName) {
        this.userID = UserID;
        this.userName = userName;
        this.role = role;
    }

    public UserRoles getRole() {
        return role;
    }

    String getUserName() {
        return userName;
    }

    public int getUserID() {
        return userID;
    }
}
