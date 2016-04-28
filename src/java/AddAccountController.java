public class AddAccountController {

   private Form addAccountForm;
   private Notification notification;
   //private Account user;
   private TomcatFormBuilder addAcctFormBuilder;
   private TomcatNotificationFactory notifyFactory;
   
   public AddAccountController(TomcatFormBuilder formBuilder, TomCatNotificationFactory notifFact) {
      addAccountForm = null;
      notification = null;
      addAcctFormBuilder = formBuilder;
      notifyFactory = notifFact;
   }
   
   private Form create() {
      addAcctFormBuilder.addField("Username");
      addAcctFormBuilder.addField("Password");
      addAcctFormBuilder.addField("ID Number");
      //addAcctFormBuilder.addField("
   }
   
   public Form clickAccountButton() {
      addAccountForm = create();
      return addAccountForm;
   }
   
   public Notification submitForm(Form form) {
      addAccountForm = form;
      return notification;   //???????
   }
   
}