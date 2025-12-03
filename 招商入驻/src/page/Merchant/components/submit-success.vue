<template>
  <div class="submit-success-wrap">
    <div class="wanc">
      <img src="@/assets/image/public/wanc.png" />
    </div>
    <div class="title">{{ $t('店铺入住申请已提交，请联系客服获取加速认证') }}</div>
    <div class="success-but-wrap">
      <div class="but but-one" @click="openUrl(2)">{{ $t('联系客服') }}</div>
      <div class="but but-two" @click="openUrl(1)">{{ $t('去登录') }}</div>
    </div>
    <div class="step-wrap1">
      <ul>
        <li>
          <div class="step-img">
            <div :class="[status === 0 ? 'span-success' : 'span-pidding']"></div>
          </div>
          <div class="text">{{ $t('提交申请表') }}</div>
        </li>
        <li>
          <div class="step-img">
            <div :class="[status === 1 ? 'span-success' : 'span-pidding']"></div>
          </div>
          <div class="text">{{ $t('背景审计') }}</div>
        </li>
        <li>
          <div class="step-img">
            <div :class="[status === 2 ? 'span-success' : 'span-pidding']"></div>
          </div>
          <div class="text">{{ $t('成为店主') }}</div>
        </li>
      </ul>
    </div>
    <div
      class="advertise-img"
      v-if="itemname !== 'Sam-wholesaleShop' && itemname !== 'Sky City' && itemname !== 'Azedi'&& itemname !== 'SM-wholesale shop' && itemname !== 'FamilyShop' && itemname !== 'INT Overstock'&& itemname !== 'EShop'"
    >
      <img src="@/assets/image/Merchant/advertise.jpg" />
    </div>
    <div class="advertise-img" v-if="itemname == 'SM-wholesale shop'">
      <img src="@/assets/image/Merchant/advertiseJ.jpg" />
    </div>
    <div class="advertise-img" v-if="itemname == 'FamilyShop'">
      <img src="@/assets/image/Merchant/advertiseF.png" />
    </div>
    <div class="advertise-img" v-if="itemname == 'INT Overstock'">
      <img src="@/assets/image/Merchant/int-banner.png" />
    </div>
    <div class="advertise-img" v-if="itemname == 'EShop'">
      <img src="@/assets/image/Merchant/EShop-banner.jpg" />
    </div>
    <div class="advertise-img" v-if="itemname == 'Azedi'">
      <img src="@/assets/image/Merchant/Azedi-banner.png" />
    </div>
    <div class="advertise-img" v-if="itemname == 'Sky City'">
      <img src="@/assets/image/Sky_banner.png" />
    </div>
    <div class="advertise-img" v-if="itemname == 'Sam-wholesaleShop'">
      <img src="@/assets/image/Sam_banner.png" />
    </div>
    <div class="tc" v-if="sellerSign">
      <p class="padding-tb">{{$t('s1')}}</p>
      <p>
        <!-- {{ $t("rzTitle1info") }} -->
        {{$t('s2',{ name: itemname })}}
      </p>
      <p>
        <!-- {{ $t("rzTitle1info1") }} -->
        {{$t('s3')}}
      </p>
      <p>{{$t('s4')}}</p>
      <p>
        <!-- {{ $t("rzTitle1info2") }} -->
        {{$t('s5')}}
      </p>
      <p>{{$t('s6')}}</p>
      <p>{{$t('s7')}}</p>
      <p>{{$t('s8')}}</p>
      <p>{{$t('s9')}}</p>
      <p>{{$t('s10')}}</p>
      <!-- <p class="padding-tb">{{ $t("rzTitle2") }}</p> -->

      <p class="padding-tb">{{$t('s11')}}</p>
      <p>
        <!-- {{ $t("rzTitle2info", { name: itemname }) }} -->
        {{$t('s12')}}
      </p>
      <p>
        <!-- {{ $t("rzTitle2info1") }} -->
        {{$t('s13')}}
      </p>
      <p>
        <!-- {{ $t("rzTitle2info2") }} -->
        {{$t('s14')}}
      </p>
      <!-- <p>
              {{ $t("rzTitle2info3") }}
      </p>-->
      <!-- <p class="padding-tb">{{ $t("rzTitle3") }}</p> -->
      <p class="padding-tb">{{$t('s15')}}</p>
      <p>
        <!-- {{ $t("rzTitle3info") }} -->
        {{$t('s16',{ name: itemname })}}
      </p>
      <p>
        <!-- {{ $t("rzTitle3info1") }} -->
        {{$t('s17')}}
      </p>
      <p>
        <!-- {{ $t("rzTitle3info2") }} -->
        {{$t('s18')}}
      </p>
      <p>{{$t('s19',{ name: itemname })}}</p>
      <p>{{$t('s20')}}</p>
      <p>{{$t('s21')}}</p>
      <!-- <p class="padding-tb">{{ $t("rzTitle4") }}</p> -->
      <!-- <p>
              {{ $t("rzTitle4info") }}

            </p>
            <p>
              {{ $t("rzTitle4info1") }}
      </p>-->
    </div>
    <Service :isShow="isShow" :token="token" @show="closeService" />
  </div>
</template>

<script>
// import { Toast } from "vant";
import Service from "@/page/customerService/pcIndex.vue";
import { is_mobile } from "@/utils/utis";
import { apiGetCustomerService } from "@/API/home.js";
import { getStatus } from "@/API/commodity";
import { HOST_URL } from "@/config";
export default {
  name: "submitSuccess",
  components: { Service },
  props: {
    sellerSign: {
      default: false
    },
    token: {
      default: ""
    }
  },
  data() {
    return {
      itemname: process.env.VUE_APP_ITEM_NAME,
      status: 0,
      screenWidth: document.body.clientWidth,
      labelPosition: "top",
      isShow: false,
      onlinePath: "",
      HOST_URL
    };
  },
  computed: {},
  created() {
    // this.getStatusInfo()

    if (this.screenWidth >= 500) {
      this.labelPosition = "left";
    } else {
      this.labelPosition = "top";
    }
    this.getOnlinePath();
  },
  methods: {
    async getOnlinePath() {
      let res = await apiGetCustomerService({ code: "customer_service_url" });
      this.onlinePath = res.customer_service_url;
    },
    //查询店铺申请进度
    getStatusInfo() {
      getStatus({}).then(res => {
        this.status = res.status;
      });
    },
    closeService(val) {
      this.isShow = val;
    },
    openUrl(index) {
      switch (index) {
        case 1:
          if (this.labelPosition == "left") {
            window.location.href = location.origin + "/ww";
            // window.location.href = location.origin+"/ww"
          }
          if (this.labelPosition == "top") {
            if (parent !== window) {
              window.open(parent.location.origin + "/www");
            } else {
              window.location.href = location.origin + "/www";
            }
          }

          break;
        case 2:
          if (this.itemname == "FamilyShop") {
            im_create_iframe_client.open();
            return;
          }
          if (this.onlinePath) {
            window.open(this.onlinePath, "_blank");
          } else if (is_mobile()) {
            this.$router.push({
              path: "/customerServiceIndex",
              query: { token: this.token }
            });
          } else {
            this.isShow = true;
          }

          break;
        default:
          break;
      }
    }
  }
};
</script>

<style lang="scss" scoped>
.submit-success-wrap {
  width: 1200px;
  border: 1px solid #eeeeee;
  border-radius: 4px;
  margin: 0 auto;
  padding-bottom: 30px;
  margin-bottom: 30px;
  background: #fff;
  .wanc {
    margin-top: 70px;

    img {
      width: 100px;
      height: 100px;
      display: block;
      margin: 0 auto;
    }
  }

  .title {
    font-size: 16px;
    color: #333333;
    line-height: 22px;
    width: 700px;
    margin: 0 auto;
    text-align: center;
    margin-top: 40px;
  }

  .success-but-wrap {
    display: flex;
    justify-content: center;
    margin-top: 70px;
    cursor: pointer;
    .but {
      width: 255px;
      height: 50px;
      border-radius: 4px;
      text-align: center;
      line-height: 50px;
      font-size: 16px;
      overflow: hidden;
      text-overflow: ellipsis;
    }

    .but-one {
      border: 1px solid #eeeeee;
      color: #333333;
    }

    .but-two {
      background: var(--color-main);
      color: #fff;
      margin-left: 40px;
    }
  }

  .step-wrap1 {
    margin-top: 100px;

    ul {
      display: flex;
      justify-content: center;

      li {
        width: 280px;
        position: relative;

        .step-img {
          height: 55px;
          display: flex;
          align-items: center;

          .span-success {
            width: 34px;
            height: 34px;
            background: url("@/assets/image/public/wanc.png");
            background-size: 100% 100%;
            margin: 0 auto;
          }

          .span-pidding {
            width: 28px;
            height: 28px;
            background: url("@/assets/image/Merchant/wanc2.png");
            background-size: 100% 100%;
            margin: 0 auto;
          }
        }

        .text {
          font-size: 16px;
          color: #333333;
          text-align: center;
        }
      }

      li:not(:last-child) {
        &::after {
          background: #eeeeee;
          position: absolute;
          content: "";
          right: 0;
          top: 40%;
          width: 110px;
          height: 2px;
        }
      }

      li:not(:first-child) {
        &::before {
          background: #eeeeee;
          position: absolute;
          content: "";
          left: 0;
          top: 40%;
          width: 110px;
          height: 2px;
        }
      }
    }
  }

  .advertise-img {
    width: 938px;
    margin: 0 auto;
    margin-top: 40px;

    img {
      width: 100%;
    }
  }
}

@media screen and (max-width: 500px) {
  .tc {
    width: auto !important;
  }
  .submit-success-wrap {
    width: 100% !important;

    .wanc {
      margin-top: 70px;

      img {
      }
    }

    .title {
      font-size: 16px;
      color: #333333;
      line-height: 22px;
      margin: 0 auto;
      width: 100%;
      text-align: center;
      margin-top: 40px;
    }

    .success-but-wrap {
      display: block;
      margin-top: 70px;

      .but {
        width: 80%;
        margin: 0 auto;
      }

      .but-two {
        background: var(--color-main);
        color: #fff;
        margin-left: 40px;
        margin-top: 20px;
      }
    }

    .step-wrap1 {
      margin-top: 30px;

      ul {
        display: block !important;

        li {
          width: 280px;
          position: relative;
          margin: 0 auto;
          margin-top: 20px;

          .step-img {
            height: 55px;
            display: flex;
            align-items: center;
          }

          .text {
            font-size: 16px;
            color: #333333;
            text-align: center;
          }
        }

        li {
          &::after {
            height: 0px !important;
          }
        }

        li {
          &::before {
            height: 0px !important;
          }
        }
      }
    }

    .advertise-img {
      width: 90% !important;
    }
  }
}
.tc {
  padding: 0 20px;
  width: 938px;
  margin: 0 auto;
  p {
    font-family: "PingFang HK";
    font-style: normal;
    font-size: 14px;
    // line-height: 20px;
    color: #333333;
    padding: 6px 0;
  }
  .padding-tb {
    color: #333333;
    font-weight: 600;
    padding: 10px 0 !important;
    img {
      width: 84px;
    }
  }
}
</style>
