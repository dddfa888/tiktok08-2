<template>
  <div class="app">
    <!-- 顶部导航 -->
    <header>
      <img src="@/assets/image/logo.jpg" alt="SPAR" class="logo" />
    </header>

    <!-- 轮播图 -->
    <div class="carousel">
      <van-swipe :autoplay="4000" indicator-color="white" show-indicators>
        <van-swipe-item v-for="(item, index) in slides" :key="index">
          <img class="carousel-img" :src="item" :alt="'轮播图' + (index + 1)" />
        </van-swipe-item>
      </van-swipe>
    </div>

    <!-- 第一行导航   -->
    <section class="nav-section">
      <div class="nav-item" v-for="(item, index) in navList1" :key="index">
        <img :src="item.img" alt="nav" />
        <div class="nav-text red">{{ item.name }}</div>
      </div>
    </section>

    <!-- 第二行导航 -->
    <section class="nav-section">
      <div class="nav-item" v-for="(item, index) in navList2" :key="index">
        <img :src="item.img" alt="nav" />
        <div class="nav-text green">{{ item.name }}</div>
      </div>
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
    <div class="timeline">
      <div class="timeline-item" v-for="(item, index) in newsList" :key="index">
        <div class="circle"></div>
        <div class="timeline-content">
          <div class="date">{{ item.date }}</div>
          <div class="title">{{ item.title }}</div>
          <div class="desc">{{ item.desc }}</div>
        </div>
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
          desc: "SPAR家家悦菏泽龙广店盛装启幕，为顾客带来更舒适的购物体验。"
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
        }
      ]
    };
  }
};
</script>

<style scoped>
.app {
  width: 100%;
  overflow-x: hidden;
  font-family: "PingFang SC", sans-serif;
  padding-bottom: 50px;
}

/* 顶部导航 */
header {
  height: 50px;
  display: flex;
  align-items: center;
  justify-content: center;
  background: #fff;
  position: fixed;
  top: 0;
  width: 100%;
  z-index: 99;
  box-shadow: 0 2px 5px rgba(0, 0, 0, 0.05);
}
.logo {
  width: 120px;
  height: auto;
}

/* 轮播图 */
.carousel {
  margin-top: 50px;
}
.carousel-img {
  width: 100%;
  height: 220px;
  object-fit: cover;
}

/* nav 区域 */
.nav-section {
  display: flex;
  flex-wrap: wrap;
  background: #f5f5f5;
  padding: 20px 0;
  justify-content: space-around;
}
.nav-item {
  width: 30%;
  text-align: center;
  margin-bottom: 15px;
}
.nav-item img {
  width: 50px;
  height: 50px;
  margin-bottom: 8px;
}
.nav-text {
  font-size: 13px;
  font-weight: 500;
}
.nav-text.red {
  color: #dd3333;
}
.nav-text.green {
  color: #2c8750;
}

/* 背景模块 */
.back {
  width: 100%;
  height: 220px;
  display: flex;
  align-items: center;
  justify-content: center;
  color: white;
  font-size: 18px;
  background-size: cover;
  text-align: center;
}

/* 时间轴 */
.timeline {
  background: #fff;
  padding: 20px;
}
.timeline-item {
  position: relative;
  padding-left: 30px;
  margin-bottom: 25px;
}
.circle {
  width: 12px;
  height: 12px;
  background: #0f6532;
  border-radius: 50%;
  position: absolute;
  left: 0;
  top: 10px;
}
.timeline-content .date {
  font-size: 12px;
  color: #888;
  margin-bottom: 5px;
}
.timeline-content .title {
  font-size: 15px;
  font-weight: 600;
  color: #222;
  margin-bottom: 4px;
}
.timeline-content .desc {
  font-size: 13px;
  color: #555;
  line-height: 1.4;
}

/* 底部横幅 */
.join-us {
  width: 100%;
  height: 200px;
  position: relative;
  display: flex;
  align-items: center;
  justify-content: center;
  color: white;
  font-size: 18px;
}
.join-us::after {
  content: "";
  position: absolute;
  inset: 0;
  background-color: rgba(0, 0, 0, 0.35);
}
.join-text {
  position: relative;
  z-index: 2;
}
</style>
