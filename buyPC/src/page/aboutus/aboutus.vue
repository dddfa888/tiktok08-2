<template>
  <div class="app">
    <!-- 顶部导航 -->
    <header>
      <div>
        <img src="@/assets/image/logo.jpg" alt="SPAR" class="h-8" />
      </div>
    </header>

    <!-- 轮播图 -->
    <div class="block text-center" style="margin-top: 60px">
      <el-carousel :height="'570px'" :interval="5000" arrow="always" indicator-position="outside">
        <el-carousel-item v-for="(item, index) in slides" :key="index">
          <img class="carousel-img" :src="item" :alt="'轮播图' + (index + 1)" />
        </el-carousel-item>
      </el-carousel>
    </div>

    <!-- nav导航 -->
    <section>
      <el-row>
        <el-col v-for="(item, index) in navList1" :key="index" :span="4">
          <img :src="item.img" alt="nav" class="w-full" />
          <div style="color: #dd3333">{{ item.name }}</div>
        </el-col>
      </el-row>
    </section>

    <!-- nav导航 -->
    <section>
      <el-row>
        <el-col v-for="(item, index) in navList2" :key="index" :span="4">
          <img :src="item.img" alt="nav" class="w-full" />
          <div style="color: #2c8750">{{ item.name }}</div>
        </el-col>
      </el-row>
    </section>

    <!-- 背景模块 -->
    <div
      class="back"
      :style="{
    backgroundImage: `url('${backImg}')`,
    backgroundRepeat: 'no-repeat',
    backgroundPosition: 'center',
    backgroundSize: 'cover'
  }"
    >
      <div class="content">遍布全球49国的自愿连锁体系</div>
    </div>

    <!-- 时间轴 -->
    <div class="timeline-page">
      <div class="timeline-container">
        <div class="timeline-line"></div>

        <div
          class="timeline-item"
          v-for="(item, index) in newsList"
          :key="index"
          :class="index % 2 === 0 ? 'left' : 'right'"
        >
          <div class="timeline-content">
            <h3 class="news-title">{{ item.title }}</h3>
            <p class="news-desc">{{ item.desc }}</p>
          </div>
          <div class="timeline-time">
            <div class="date">{{ item.date.split(' ')[0] }}</div>
            <div class="year">{{ item.date.split(' ')[1] }}</div>
          </div>
          <div class="circle"></div>
        </div>
      </div>

      <!-- 底部横幅 -->
      <div
        class="join-us"
        :style="{
    backgroundImage: `url('${bannar2}')`,
    backgroundRepeat: 'no-repeat',
    backgroundPosition: 'center',
    backgroundSize: 'cover'
  }"
      >
        <div class="join-text">加入我们</div>
      </div>
    </div>
  </div>
</template>

<script>
import bannar1 from "@/assets/image/bannar.jpg";
import bannar2 from "@/assets/image/bannar2.jpg";
import bannar3 from "@/assets/image/bannar3.jpg";
import bannar5 from "@/assets/image/bannar5.jpg";
import backImg from "@/assets/image/back.jpg";
import nav1 from "@/assets/image/nav1.png";
import nav2 from "@/assets/image/nav2.png";
import nav3 from "@/assets/image/nav3.png";
import nav4 from "@/assets/image/nav4.png";
import nav5 from "@/assets/image/nav5.png";
import nav6 from "@/assets/image/nav6.png";
import nav7 from "@/assets/image/nav7.png";
import nav8 from "@/assets/image/nav8.png";
import nav9 from "@/assets/image/nav9.png";
import nav10 from "@/assets/image/nav10.png";
import nav11 from "@/assets/image/nav11.png";
import nav12 from "@/assets/image/nav12.png";

export default {
  name: "HomePage",
  data() {
    return {
      backImg,
      bannar2,
      slides: [bannar1, bannar2, bannar3, bannar5],
      navList1: [
        { name: "SPAR中国2024", img: nav1 },
        { name: "402亿元销售额", img: nav2 },
        { name: "全国41个城市", img: nav3 },
        { name: "1140家门店", img: nav4 },
        { name: "15座配送中心", img: nav5 },
        { name: "50,000名员工", img: nav6 }
      ],
      navList2: [
        { name: "SPAR国际2024", img: nav7 },
        { name: "493亿欧元销售额", img: nav8 },
        { name: "全球49个国家", img: nav9 },
        { name: "13,809家门店", img: nav10 },
        { name: "258座配送中心", img: nav11 },
        { name: "470,000名员工", img: nav12 }
      ],
      newsList: [
        {
          date: "09-29 2025",
          title: "重装开业 | SPAR家家悦菏泽龙广店重装启幕",
          desc:
            "SPAR家家悦菏泽龙广店于9月29日盛装启幕，经过焕新升级，店铺焕然一新，为顾客带来更舒适的购物体验。"
        },
        {
          date: "09-22 2025",
          title: "研学课堂 | 跟SPAR“小店长”一起探索超市的秘密",
          desc: "SPAR组织儿童体验营活动，让孩子们走进超市学习知识、体验职业。"
        },
        {
          date: "09-15 2025",
          title: "重装开业 | SPAR家家悦济南历城新店启幕",
          desc: "SPAR历城新店正式开业，提供优质商品和舒适购物环境。"
        },
        {
          date: "09-01 2025",
          title: "焕新升级 | SPAR家家悦泰安东岳大街店焕新亮相",
          desc: "经过全面装修升级，店面环境焕然一新，进一步提升顾客体验。"
        },
        {
          date: "08-18 2025",
          title: "国际 | SPAR捷报频传，成功迈向新市场",
          desc: "SPAR持续扩大国际版图，在多地成功开设新门店。"
        },
        {
          date: "07-28 2025",
          title: "SPAR英国 | 如何持续跨越百年传承的秘密",
          desc: "SPAR英国门店持续发展，以创新和服务赢得顾客信赖。"
        },
        {
          date: "07-14 2025",
          title: "榆树首销 | SPAR榆树新店盛大开业",
          desc: "SPAR榆树店隆重开业，为当地居民提供优质商品和服务。"
        },
        {
          date: "07-07 2025",
          title: "SPAR家家悦 | 服务至臻 海纳百川",
          desc: "SPAR家家悦持续致力于打造全球一流零售品牌。"
        }
      ]
    };
  }
};
</script>

<style scoped>
.app {
  width: 100%;
  height: 100%;
  margin: 0;
  padding: 0;
  overflow-x: hidden; /* ✅ 防止整个页面横向滚动 */
}

/* 顶部导航 */
header {
  width: 100%;
  position: fixed;
  height: 60px;
  top: 0;
  left: 0;
  display: flex;
  z-index: 999;
  align-items: center;
  background-color: #fff;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.05);
}

header div {
  margin-left: 50px;
}

header div img {
  width: 182px;
}

/* 导航区块 */
section {
  min-height: 162.24px;
  padding-top: 2vh;
  padding-bottom: 2vh;
  background-color: #f5f5f5;
}

section .el-row .el-col {
  display: flex;
  flex-direction: column;
  justify-content: space-around;
  align-items: center;
}

section .el-row .el-col img {
  margin-bottom: 30px;
  max-width: 80px;
  height: auto;
}

/* 轮播图 */
.el-carousel__item img {
  object-fit: cover;
  transition: transform 6s ease-in-out;
}

.el-carousel__item.is-active img {
  transform: scale(1.08);
}

.carousel-img {
  width: 100%;
  height: 100%;
  object-fit: cover;
  transition: transform 6s ease-in-out, opacity 1s ease;
}

.el-carousel__item.is-active .carousel-img {
  transform: scale(1.08);
  opacity: 1;
}

/* 背景模块 */
.back {
  position: relative;
  width: 100%;
  height: 300px;
  overflow: hidden;
  line-height: 300px;
}

.back::before {
  content: "";
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-attachment: fixed;
  z-index: 0;
}

.back::after {
  content: "";
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(15, 101, 50, 0.7);
  z-index: 1;
}

.back .content {
  position: relative;
  z-index: 2;
  color: white;
  text-align: center;
  font-size: 25px;
}

/* 时间轴主容器 */
.timeline-page {
  width: 100%;
  max-width: 100vw;
  overflow-x: hidden;
  padding: 0 10px;
}

.timeline-container {
  position: relative;
  margin: 0 auto;
  padding: 40px 0;
  width: 100%;
}

.timeline-line {
  position: absolute;
  left: 50%;
  top: 0;
  bottom: 0;
  width: 2px;
  background: #ddd;
  transform: translateX(-50%);
  z-index: 0;
}

.timeline-item {
  position: relative;
  width: 50%;
  padding: 20px;
  box-sizing: border-box;
}

.timeline-item.left {
  text-align: right;
  left: 0;
}

.timeline-item.right {
  text-align: left;
  left: 50%;
}

.timeline-content {
  background: #fff;
  border-radius: 10px;
  padding: 15px;
  display: inline-block;
  max-width: 90%;
  z-index: 2;
  position: relative;
  box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
}

.timeline-time {
  font-size: 14px;
  color: #666;
  margin-top: 8px;
}

.circle {
  position: absolute;
  top: 25px;
  width: 16px;
  height: 16px;
  background: #fff;
  border: 2px solid #ff5a5f;
  border-radius: 50%;
  z-index: 3;
}

.timeline-item.left .circle {
  right: -8px;
}

.timeline-item.right .circle {
  left: -8px;
}

/* ✅ 手机端修复关键：单列布局 */
@media screen and (max-width: 768px) {
  .timeline-line {
    left: 20px; /* 竖线靠左 */
    transform: none;
  }

  .timeline-item {
    width: 100%;
    left: 0 !important;
    text-align: left;
    padding-left: 50px; /* 给竖线留空间 */
  }

  .timeline-item.left,
  .timeline-item.right {
    left: 0 !important;
    transform: none !important;
  }

  .timeline-content {
    max-width: 100%;
  }

  .circle {
    left: 15px;
    right: auto;
  }
}

.news-title {
  font-size: 18px;
  font-weight: 600;
  color: #333;
  margin-bottom: 8px;
}

.news-desc {
  font-size: 14px;
  color: #666;
  line-height: 1.6;
}

/* 时间样式 */
.timeline-time {
  position: absolute;
  top: 35px;
  width: 90px;
  color: #888;
  font-size: 14px;
  line-height: 1.2;
  text-align: center;
}

.timeline-item.left .timeline-time {
  right: -160px;
}

.timeline-item.right .timeline-time {
  left: -160px;
}

.timeline-time .date {
  font-weight: 600;
  font-size: 18px;
  color: #333;
}

.timeline-time .year {
  font-size: 12px;
  color: #999;
}

/* 中间圆点 */
.circle {
  position: absolute;
  top: 40px;
  left: 100%;
  width: 14px;
  height: 14px;
  border-radius: 50%;
  background-color: #0f6532;
  border: 3px solid #fff;
  transform: translateX(-50%);
  z-index: 2;
}

.timeline-item.right .circle {
  left: 0;
  transform: translateX(-50%);
}

/* 底部横幅 */
.join-us {
  position: relative;
  width: 100%;
  height: 400px;
  overflow: hidden;
  line-height: 400px;
}

.join-us::before {
  content: "";
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-attachment: fixed;
  z-index: 0;
}

.join-us::after {
  content: "";
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.3);
  z-index: 1;
}

.join-us .join-text {
  position: relative;
  z-index: 2;
  color: white;
  text-align: center;
  font-size: 25px;
}

/* ✅ 响应式媒体查询 */

/* --- 平板 (≤1200px) --- */
@media (max-width: 1200px) {
  header div {
    margin-left: 20px;
  }

  header div img {
    width: 150px;
  }

  section .el-row .el-col img {
    max-width: 70px;
  }

  .timeline-container {
    width: 85%;
  }
}

/* --- 平板小屏 (≤992px) --- */
@media (max-width: 992px) {
  .el-carousel__item img {
    height: 400px;
  }

  section {
    padding-top: 3vh;
    padding-bottom: 3vh;
  }

  .timeline-container {
    width: 90%;
  }

  .timeline-item {
    width: 100%;
    text-align: left !important;
    transform: none !important;
    padding-left: 60px;
  }

  .timeline-line {
    left: 20px;
  }

  .timeline-time {
    position: relative;
    left: 0;
    right: 0;
    margin-bottom: 8px;
    text-align: left;
  }

  .circle {
    left: 20px;
    transform: translateX(-50%);
  }

  .back,
  .join-us {
    height: 250px;
    line-height: 250px;
  }

  .back .content,
  .join-us .join-text {
    font-size: 20px;
  }
}

/* --- 手机端 (≤768px) --- */
@media (max-width: 768px) {
  header {
    height: 50px;
  }

  header div img {
    width: 120px;
  }

  .el-carousel__item img {
    height: 250px;
  }

  section .el-row {
    flex-wrap: wrap;
  }

  section .el-row .el-col {
    flex: 0 0 33.33%;
    max-width: 33.33%;
    margin-bottom: 15px;
  }

  section .el-row .el-col img {
    max-width: 60px;
    margin-bottom: 10px;
  }

  section .el-row .el-col div {
    font-size: 12px;
  }

  .back .content {
    font-size: 18px;
  }

  .timeline-container {
    width: 95%;
    margin: 60px auto;
  }

  .news-title {
    font-size: 16px;
  }

  .news-desc {
    font-size: 13px;
  }

  .join-us {
    height: 220px;
    line-height: 220px;
  }

  .join-us .join-text {
    font-size: 18px;
  }
}

/* --- 超小屏 (≤480px) --- */
@media (max-width: 480px) {
  header div img {
    width: 100px;
  }

  .el-carousel__item img {
    height: 180px;
  }

  section .el-row .el-col {
    flex: 0 0 50%;
    max-width: 50%;
  }

  .back .content {
    font-size: 16px;
  }

  .join-us .join-text {
    font-size: 16px;
  }

  .news-title {
    font-size: 14px;
  }

  .news-desc {
    font-size: 12px;
  }
}
</style>

