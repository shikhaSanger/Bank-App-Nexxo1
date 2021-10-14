package controllers;

import com.google.inject.Inject;
import dto.*;
import play.data.Form;
import play.data.FormFactory;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import services.*;

import java.util.ArrayList;
import java.util.List;

//import play.redis.Redis;


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
        return ok();
    }


    public Result login(Http.Request request) {

        LoginRequestDto loginRequestDto = new LoginRequestDto();
        LoginResponseDto loginResponseDto = new LoginResponseDto();

        System.out.print("JSON" + request.body().toString());
        Form<LoginRequestDto> loginRequestDtoForm =
                formFactory.form(LoginRequestDto.class).bindFromRequest(request);
        loginRequestDto = loginRequestDtoForm.get();
        System.out.println("login email id is..."+loginRequestDto.getEmail());
        System.out.println("login email id is..."+loginRequestDto.getPassword());

        loginResponseDto = loginService.loginValidation(loginRequestDto);
        //Jedis jedis = new Jedis("localhost");
        //jedis.set("email", loginRequestDto.getEmail());
        //
        // System.out.println(jedis.get("email"));
        //Redis.set();
        System.out.println(loginResponseDto);
        return ok(Json.toJson(loginResponseDto));//.addingToSession(request, "connected", "user@gmail.com");
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
        RegistrationResponseDto registrationResponseDto = new RegistrationResponseDto();
        //JsonNode jsonNode=request.body().asJson();
        System.out.print("JSON" +request.body().toString());
        // requestDto= (RegistrationRequestDto) Json.fromJson(jsonNode, RegistrationRequestDto.class);
        Form<RegistrationRequestDto> registrationForm =
                formFactory.form(RegistrationRequestDto.class).bindFromRequest(request);
        System.out.println(registrationForm.get().getUsername() + " FORM ");
        requestDto=registrationForm.get();
        registrationResponseDto=registrationService.save(requestDto);

        return ok(Json.toJson(registrationResponseDto));

    }
    public Result withDraw(Http.Request request){

       WithdrawRequestDto withdrawRequestDto=new WithdrawRequestDto();
       WithdrawResponseDto withdrawResponseDto=new WithdrawResponseDto();
       System.out.print("JSON" +request.body().toString());
        Form<WithdrawRequestDto> withdrawRequestDtoForm =
                formFactory.form(WithdrawRequestDto.class).bindFromRequest(request);

        withdrawRequestDto=withdrawRequestDtoForm.get();
        System.out.println("id is .."+withdrawRequestDto.getId());
        System.out.println("amount is .."+withdrawRequestDto.getAmount());
        System.out.println("description is .."+withdrawRequestDto.getDescription());

        withdrawResponseDto=withDrawService.withDrawMoney(withdrawRequestDto);
        return ok(Json.toJson(withdrawResponseDto));
    }

    public Result listOfCustomer(){
        List<ListOfCustomerResponseDto> listOfCustomerResponseDtoList= new ArrayList<>();

        listOfCustomerResponseDtoList= listOfCustomerService.listOfCustomer();
        //return ok(Json.toJson(listOfCustomerResponseDtoList));
        System.out.println("FOund "  + listOfCustomerResponseDtoList.size());
     // return ok(views.html.List_of_customer.render(listOfCustomerResponseDtoList));
        return ok(Json.toJson(listOfCustomerResponseDtoList));
    }

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

public Result adminPage(Http.Request request){
    System.out.println("session " +request.session().get("connected"));
        AdminRequestDto adminRequestDto=new AdminRequestDto();
        AdminResponseDto adminResponseDto=new AdminResponseDto();
        System.out.print("JSON" +request.body().toString());
        Form<AdminRequestDto> adminRequestDtoForm =
            formFactory.form(AdminRequestDto.class).bindFromRequest(request);
        adminRequestDto=adminRequestDtoForm.get();
        adminResponseDto = AdminService.adminPage(adminRequestDto);
        return ok(Json.toJson(adminResponseDto));

}

  public Result transactionHistory(Http.Request request){
        TransactionHistoryRequestDto transactionHistoryRequestDto=new TransactionHistoryRequestDto();
        List<TransactionHistoryResponseDto> transactionHistoryResponseDtoList=new ArrayList<TransactionHistoryResponseDto>();
        System.out.print("JSON" +request.body().toString());
        Form<TransactionHistoryRequestDto> transactionHistoryRequestDtoForm=
              formFactory.form(TransactionHistoryRequestDto.class).bindFromRequest(request);
        transactionHistoryRequestDto=transactionHistoryRequestDtoForm.get();
        System.out.println("id is .."+transactionHistoryRequestDto.getId());
        transactionHistoryResponseDtoList=transactionHistoryService.transactionHistoryService(transactionHistoryRequestDto);
      return ok(Json.toJson(transactionHistoryResponseDtoList));
  }

}
