public class AddAccountController {

   private Form addAccountForm;
   private Notification notification;
   
   public void create() {
   
   }
   
   public Form clickAccountButton() {
      create();
      return addAccountForm;
   }
   
   public Notification submitForm(Form form) {
      addAccountForm = form;
      return notification;   //???????
   }
   
}