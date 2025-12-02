 

package com.auto.mall.api;

import com.auto.mall.api.req.PromoteReq;
import com.auto.mall.api.resp.PromoteResp;
import com.auto.mall.exception.MallToolGlobalException;
import com.auto.mall.response.JsonResponse;
import com.auto.mall.service.PromoteService;
import com.auto.mall.service.UserRecomService;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/api/promote"})
public class PromoteController {
  @Resource
  PromoteService promoteService;
  @Resource
  UserRecomService userRecomService;

  public PromoteController() {
  }

  @PostMapping({"/level"})
  public JsonResponse<List<PromoteResp>> level(PromoteReq req) {
    try {
      List<PromoteResp> list = this.promoteService.list(req);
      return JsonResponse.success(200, "", list);
    } catch (MallToolGlobalException var3) {
      MallToolGlobalException ex = var3;
      return JsonResponse.fail(ex.getCode(), ex.getMessage());
    } catch (Exception var4) {
      Exception ex1 = var4;
      ex1.printStackTrace();
      return JsonResponse.fail(500, ex1.getMessage());
    }
  }

  @PostMapping({"/distribution"})
  public JsonResponse distribution(String orderId) {
    return JsonResponse.success(200, "", this.promoteService.distribution(orderId));
  }

  @PostMapping({"/test"})
  public JsonResponse test(String sellerId) {
    return JsonResponse.success(200, "", this.userRecomService.findParents(sellerId));
  }
}
