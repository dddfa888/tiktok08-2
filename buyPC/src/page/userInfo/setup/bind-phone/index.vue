<template>
  <div class="login-password">
    <div class="page-title" style="cursor: pointer" @click="goBack">
      <i class="el-icon-arrow-left"></i> {{ $t("message.home.绑定手机号") }}
    </div>
    <el-form ref="form" class="form" :model="form">
      <el-form-item :label="$t('message.home.绑定手机号')" prop="phone">
        <!-- <el-input
          v-model="form.phone"
          type="text"
          :placeholder="$t('message.home.请输入手机号')"
        >
        </el-input> -->
        <div class="form-phone">
          <el-input
            v-model.trim="form.phone"
            :placeholder="$t('message.home.请输入手机号')"
            maxlength="30"
            class="phone_ipt"
          >
            <div slot="prepend">
              <VueCountryIntl
                v-model="form.areaCode"
                schema="popover"
                :searchInputPlaceholder="$t('message.home.searchCountry')"
                :noDataText="$t('message.home.noDataFound')"
              >
                <div class="area-code flex-between" slot="reference">
                  <span>+{{ form.areaCode }}</span>
                  <i class="el-icon-caret-bottom"></i>
                </div>
              </VueCountryIntl>
            </div>
          </el-input>
        </div>
      </el-form-item>
      <el-form-item :label="$t('message.home.password')" prop="password">
        <el-input
          v-model="form.password"
          :type="showPassword.password ? 'text' : 'password'"
          :placeholder="$t('message.home.请输入登录密码')"
        >
          <template #suffix>
            <div
              class="eye-icon"
              @click="showPassword.password = !showPassword.password"
            >
              <img
                :src="showPassword.password ? eyeIcon.open : eyeIcon.close"
                alt=""
              />
            </div>
          </template>
        </el-input>
      </el-form-item>

      <el-form-item>
        <el-button
          class="form-submit-btn"
          type="submit"
          :loading="loading"
          block
          @click="update"
        >
          {{ $t("message.home.btnSure") }}
        </el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import { mapActions } from "vuex";
import common from "@/util/common";
import { bindPhone } from "@/api/userCenter";
export default {
  data() {
    return {
      form: {
        password: "",
        phone: "",
        areaCode: "1",
      },
      showPassword: {
        password: false,
      },
      eyeIcon: {
        close: require("@/assets/image/eye-close.png"),
        open: require("@/assets/image/eye-open.png"),
      },

      loading: false,
    };
  },
  methods: {
    update() {
      console.log("this.form.newPassword ->", this.form);
      if (!this.form.phone) {
        this.$message({
          message: this.$t("message.home.请输入手机号"),
          type: "warning",
        });
        return;
      }
      if (!this.form.password) {
        this.$message({
          message: this.$t("message.home.请输入登录密码"),
          type: "warning",
        });
        return;
      }
      this.$refs.form.validate(async (valid) => {
        if (valid) {
          try {
            this.loading = true;

            await bindPhone({
              phone: `${this.form.areaCode} ${this.form.phone}`,
              password: this.form.password,
            });
            this.$message({
              message: this.$t("message.home.successTips"),
              type: "success",
            });
            this.$router.replace("/userInfo/dashboard?index=1");
          } finally {
            this.loading = false;
          }
        }
      });
    },
    goBack() {
      this.$router.push("/userInfo/setup");
    },
  },
};
</script>

<style lang="scss" scoped>
html[dir="rtl"] {
  .el-form-item /deep/ .el-form-item__error {
    right: 0;
    left: auto;
  }
  .el-form-item /deep/ .el-form-item__label {
    float: right;
  }
}
.login-password {
  width: 422px;
  .eye-icon {
    width: 30px;
    height: 40px;
    cursor: pointer;
    display: flex;
    align-items: center;
    justify-content: center;
    > img {
      width: 14px;
      margin: 0;
    }
  }
}
</style>
