<template>
    <div class="service">
      <van-nav-bar safe-area-inset-top fixed :title="$t('客服')+2" left-arrow @click-left="onClickLeft" />
      <canvas ref="qrcodeCanvas"></canvas>
      <span class="service-desc" style="display: inline-block; color: #F7CC1F;">{{$t('使用思途扫描二维码,加我为好友')}}</span>
    </div>
  </template>
  
  <script setup>
  import { ref, onMounted } from 'vue'
  import { useRouter, useRoute } from 'vue-router'
  import QRCode from 'qrcode'
  
  // 获取路由实例和路由信息
  const router = useRouter()
  const route = useRoute()
  
  // 获取 canvas 元素的 ref
  const qrcodeCanvas = ref(null)
  
  // 点击返回按钮事件
  function onClickLeft() {
    router.push({ path: '/shop', dir: 'left' })
  }
  
  // 组件挂载后生成二维码
  onMounted(() => {
    if (qrcodeCanvas.value) {
      QRCode.toCanvas(qrcodeCanvas.value, route.query.id || '', function (error) {
        if (error) console.error(error)
        else console.log('二维码生成成功')
      })
    }
  })
  </script>
  
  <style scoped>

  html, body {
    height: 100vh;
  margin: 0;
}
.service {
    width: 100%;
  height: 100vh; /* 让它撑满整个可视区域 */
  background-image: url("@/assets/qrcode.png");
  background-size: 100% 100%;
  background-repeat: no-repeat;
  position: relative;
  }
canvas {
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
}

.service-desc {
  position: absolute;
  top: 70%;
  left: 50%;
  transform: translateX(-50%);
  font-size: 14px;
  color: #F7CC1F;
  font-family: "PingFang SC", "Microsoft YaHei", sans-serif;
  max-width: 90%;
  text-align: center;         /* ✅ 居中换行 */
  word-break: break-word;     /* ✅ 长词换行 */
  line-height: 1.5;
}


  </style>
  