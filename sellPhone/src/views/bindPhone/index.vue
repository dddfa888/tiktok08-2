<template>
  <div class="changePassword">
    <fx-header>
      <template #title>
        {{ $t('绑定手机号') }}
      </template>
    </fx-header>
    <div class="line"></div>
    <div class="content">
      <ExInput
        :label="$t('手机号')"
        :placeholderText="$t('请输入手机号')"
        v-model="phone"
      />
      <ExInput
        :label="$t('登录密码')"
        :placeholderText="$t('请输入登录密码')"
        v-model="password"
        typeText="password"
      />
      <van-button
        class="w-full btn-content"
        type="primary"
        :loading="subLoading"
        @click="submit"
        >{{ $t('sure') }}</van-button
      >
    </div>
  </div>
</template>

<script setup>
import ExInput from '@/components/ex-input/index.vue'
import { bindPhone } from '@/service/user.api.js'
import { ref, nextTick } from 'vue'
import { Toast } from 'vant'
import { useRouter } from 'vue-router'
import { useI18n } from 'vue-i18n'
const { t } = useI18n()
const router = useRouter()
const subLoading = ref(false)

const phone = ref('')
const password = ref('')

const submit = () => {
  if (phone.value === '') {
    Toast(t('请输入手机号'))
    return
  }
  if (password.value === '') {
    Toast(t('请输入登录密码'))
    return
  }

  subLoading.value = true
  bindPhone({
    phone: phone.value,
    password: password.value
  })
    .then((res) => {
      Toast(t('绑定成功'))
      subLoading.value = false
      setTimeout(() => {
        router.back()
      }, 1000)
    })
    .catch((err) => {
      subLoading.value = false
    })
}

nextTick(() => {
  const mode = import.meta.env.MODE
  if (['familyMart'].includes(mode)) {
    router.back()
  }
})
</script>

<style lang="scss" scoped>
.changePassword {
  width: 100%;
  box-sizing: border-box;
  background-color: #fff;
  height: 100vh;
}

.line {
  width: 100%;
  height: 2px;
  background: #f5f5f5;
}

.content {
  padding: 16px;
  font-size: 13px;
}

.hightLight {
  background: var(--site-main-color);
  color: #fff;
}

.btn-content {
  margin-top: 10px;
  background-color: var(--site-main-color);
  border-color: var(--site-main-color);
}
</style>
