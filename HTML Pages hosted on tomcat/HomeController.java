package controllers;

import com.google.inject.Inject;

import dto.*;

import models.RoleType;
import play.data.Form;
import play.data.FormFactory;

import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import services.*;

import java.util.ArrayList;
import java.util.List;


/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    @Inject
    private RegistrationService registrationService;
    @Inject
    private LoginService loginService;
    @Inject
    private DepositePageService depositePageService;
    @Inject
    private WithdrawPageService withdrawPageService;
    @Inject
    private DepositeService depositeService;
    @Inject
   private WithDrawService withDrawService;
    @Inject
   private ListOfCustomerService listOfCustomerService;
    @Inject
    private DeactivateService deactivateService;
    @Inject
    private ActivateService activateService;
    @Inject
    private TransactionHistoryService transactionHistoryService;
   // private LoginService loginService;
   // private ActivateService activateService;
    //private DeactivateService deactivateService;
    //  private DepositeService depositeService;
  //  private ListOfCustomerService listOfCustomerService;
   // private TransactionHistoryService transactionHistoryService;
  //  private WithDrawService withDrawService;



    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result index() {

        LoginResponseDto loginResponseDto=new LoginResponseDto();
        return ok(views.html.index.render(loginResponseDto));
    }

    public Result registration() {

        //registrationService.save();
        //  RegistrationService.delete();
        // RegistrationService.update();

       return ok(views.html.Registration_form.render());
    }
    public Result depositeAmount(Http.Request request) {
       DepositePageRequestDto depositePageRequestDto=new DepositePageRequestDto();
       DepositePageResponseDto depositePageResponseDto=new DepositePageResponseDto();

        Form<DepositePageRequestDto> depositePageRequestDtoForm =
                formFactory.form(DepositePageRequestDto.class).bindFromRequest(request);
        depositePageRequestDto=depositePageRequestDtoForm.get();
        depositePageResponseDto=depositePageService.depositePage(depositePageRequestDto);

        return ok(views.html.Deposite.render(depositePageResponseDto));
    }
    public Result withdrawAmount(Http.Request request) {
        WithdrawPageRequestDto withdrawPageRequestDto=new WithdrawPageRequestDto();
        WithdrawPageResponseDto withdrawPageResponseDto=new WithdrawPageResponseDto();

        Form<WithdrawPageRequestDto> activatePageRequestDtoForm =
                formFactory.form(WithdrawPageRequestDto.class).bindFromRequest(request);
        withdrawPageRequestDto=activatePageRequestDtoForm.get();
        withdrawPageResponseDto= withdrawPageService.withdrawPage(withdrawPageRequestDto);

        return ok(views.html.Withdraw.render(withdrawPageResponseDto));
    }

//    public Result withDrawAmount() {
//
//        return ok(views.html.Withdraw.render());
//    }


//    public Result adminDashboard() {
//
//        return ok(views.html.Admin_Dashboard.render());
//    }

    public Result login(Http.Request request) {

        LoginRequestDto loginRequestDto = new LoginRequestDto();
        LoginResponseDto loginResponseDto = new LoginResponseDto();

        System.out.print("JSON" + request.body().toString());
        Form<LoginRequestDto> loginRequestDtoForm =
                formFactory.form(LoginRequestDto.class).bindFromRequest(request);
        loginRequestDto = loginRequestDtoForm.get();
        loginResponseDto = loginService.loginValidation(loginRequestDto);
        System.out.println(loginResponseDto);
        if (loginResponseDto.getRoleId() == RoleType.RoleTypeEnum.ADMIN.getId()) {

           // return redirect( "http://localhost:8080/Bank%20App/Admin_Dashboard.html");
            return ok(views.html.Admin_Dashboard.render(loginResponseDto));
        }
        if (loginResponseDto.getRoleId() == RoleType.RoleTypeEnum.Customer.getId()) {
            //return redirect( "http://localhost:8080/Bank%20App/Customer_Dashboard.html");
            return ok(views.html.Customer_Dashboard.render(loginResponseDto));
        }


       return ok(Json.toJson(loginResponseDto));
        //return ok(views.html.index.render(loginResponseDto));
    }



    public Result deposite(Http.Request request){
        DepositeRequestDto depositeRequestDto=new DepositeRequestDto();
        DepositeResponseDto depositeResponseDto=new DepositeResponseDto();
        System.out.print("JSON" +request.body().toString());
        Form<DepositeRequestDto> depositeRequestDtoForm =
                formFactory.form(DepositeRequestDto.class).bindFromRequest(request);
        depositeRequestDto=depositeRequestDtoForm.get();

        depositeResponseDto= depositeService.addBalance(depositeRequestDto);

        return ok(Json.toJson(depositeResponseDto));

    }

    @Inject
    private FormFactory formFactory;
    public Result saveData(Http.Request request){
        RegistrationRequestDto requestDto=new RegistrationRequestDto();
        //JsonNode jsonNode=request.body().asJson();
        System.out.print("JSON" +request.body().toString());
        // requestDto= (RegistrationRequestDto) Json.fromJson(jsonNode, RegistrationRequestDto.class);
        Form<RegistrationRequestDto> registrationForm =
                formFactory.form(RegistrationRequestDto.class).bindFromRequest(request);
        System.out.println(registrationForm.get().getUsername() + " FORM ");
        requestDto=registrationForm.get();
        registrationService.save(requestDto);
        RegistrationResponseDto responseDto=new RegistrationResponseDto();
        responseDto.setStatus(200);
        responseDto.setMessage("successfully done");

        return ok(Json.toJson(responseDto));

    }
    public Result withDraw(Http.Request request){

       WithdrawRequestDto withdrawRequestDto=new WithdrawRequestDto();
       WithdrawResponseDto withdrawResponseDto=new WithdrawResponseDto();
        System.out.print("JSON" +request.body().toString());
        Form<WithdrawRequestDto> withdrawRequestDtoForm =
                formFactory.form(WithdrawRequestDto.class).bindFromRequest(request);

        withdrawRequestDto=withdrawRequestDtoForm.get();

        withdrawResponseDto=withDrawService.withDrawMoney(withdrawRequestDto);
        return ok(Json.toJson(withdrawResponseDto));
    }

    public Result listOfCustomer(){
        //System.out.println("Inside list of customer ");
      //  ListOfCustomerRequestDto listOfCustomerRequestDto=new ListOfCustomerRequestDto();
        List<ListOfCustomerResponseDto> listOfCustomerResponseDtoList= new ArrayList<>();
       // Form<ListOfCustomerRequestDto> listOfCustomerRequestDtoForm =
           ///     formFactory.form(ListOfCustomerRequestDto.class).bindFromRequest(request);

       // listOfCustomerRequestDto=listOfCustomerRequestDtoForm.get();

        listOfCustomerResponseDtoList= listOfCustomerService.listOfCustomer();
        //return ok(Json.toJson(listOfCustomerResponseDtoList));
        System.out.println("FOund "  + listOfCustomerResponseDtoList.size());
      return ok(views.html.List_of_customer.render(listOfCustomerResponseDtoList));

    }

//    public Result listOfCustomer(Http.Request request, Integer roleId){
//        System.out.println("Inside list of customer ");
//        List<ListOfCustomerResponseDto> listOfCustomerResponseDtoList= new ArrayList<>();
//        listOfCustomerResponseDtoList= ListOfCustomerService.listOfCustomer(roleId);
//        //return ok(Json.toJson(listOfCustomerResponseDtoList));
//        System.out.println("FOund "  + listOfCustomerResponseDtoList.size());
//        return ok(views.html.List_of_customer.render(listOfCustomerResponseDtoList));
//
//    }


    public Result  deactivate(Http.Request request){
      DeactivateRequestDto deactivateRequestDto=new DeactivateRequestDto();
      DeactivateResponseDto deactivateResponseDto =new DeactivateResponseDto();
      System.out.print("JSON" +request.body().toString());
      Form<DeactivateRequestDto> deactivateRequestDtoForm =
              formFactory.form(DeactivateRequestDto.class).bindFromRequest(request);
      deactivateRequestDto=deactivateRequestDtoForm.get();
      deactivateResponseDto = deactivateService.deactivateService(deactivateRequestDto);
      return ok(Json.toJson(deactivateResponseDto));

  }

    public Result  activate(Http.Request request){
        ActivateRequestDto activateRequestDto=new ActivateRequestDto();
        ActivateResponseDto activateResponseDto =new ActivateResponseDto();
        System.out.print("JSON" +request.body().toString());
        Form<ActivateRequestDto> activateRequestDtoForm =
                formFactory.form(ActivateRequestDto.class).bindFromRequest(request);
        activateRequestDto=activateRequestDtoForm.get();
        activateResponseDto = activateService.activateService(activateRequestDto);
        return ok(Json.toJson(activateResponseDto));

    }




  public Result transactionHistory(Http.Request request){
        TransactionHistoryRequestDto transactionHistoryRequestDto=new TransactionHistoryRequestDto();
        List<TransactionHistoryResponseDto> transactionHistoryResponseDtoList=new ArrayList<TransactionHistoryResponseDto>();
        System.out.print("JSON" +request.body().toString());
        Form<TransactionHistoryRequestDto> transactionHistoryRequestDtoForm=
              formFactory.form(TransactionHistoryRequestDto.class).bindFromRequest(request);
        transactionHistoryRequestDto=transactionHistoryRequestDtoForm.get();
        transactionHistoryResponseDtoList=transactionHistoryService.transactionHistoryService(transactionHistoryRequestDto);
      return ok(views.html.TransactionHistory.render(transactionHistoryResponseDtoList));
  }




}
