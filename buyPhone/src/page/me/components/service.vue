<template>
    <div class="service">
        <van-nav-bar safe-area-inset-top fixed :title="$t('客服')+2"  left-arrow @click-left="onClickLeft" />
        <canvas ref="qrcodeCanvas"></canvas>
      <span class="service-desc" style="color: #F7CC1F;">{{$t('使用思途扫描二维码,加我为好友')}}</span>
    </div>
</template>

<script>
import QRCode from 'qrcode'
import { useRoute } from 'vue-router'
import {apiGetCustomerService_st} from "../../../API/common.js"

export default {
    name: 'QrCodeExample',
    methods:{
        onClickLeft() {
            this.$router.push({ path: '/me', dir: 'left' })
        },
    },
    mounted() {
        apiGetCustomerService_st().then((res)=>{
            const canvas = this.$refs.qrcodeCanvas
        QRCode.toCanvas(canvas, res.customer_service_url_st, function (error) {
            if (error) console.error(error)
            else console.log('二维码生成成功')
        })
        })
        
    }
}
</script>

<style>
.service 
{
    width: 100%;
    height: 100%;
    background: url("@/assets/qrcode.png");
    background-size: 100% 100%;
    position: relative;
}

canvas 
{
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
}
.service-desc {
  position: absolute;
  top: 65%;
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