<template>
	<div>
		<div class="newadd">
			<el-button type="primary" @click="() => $router.back()">返回</el-button>
			<el-button type="primary" @click="toAdd()">
				新增规格
			</el-button>
		</div>
		<el-table ref="multipleTable" :data="tableData" tooltip-effect="dark" style="width: 100%" border align="center"
			:key="id" :header-cell-style="{ background: '#e4e4e4' }">
			<el-table-column type="selection" width="80" align="center">
			</el-table-column>
			<el-table-column label="规格ID" align="center">
				<template slot-scope="scope">{{ scope.row.id }}</template>
			</el-table-column>
			<el-table-column prop="attrName" label="规格名称" width="200" align="center">
			</el-table-column>
			<el-table-column label="规格所属" prop="categoryName" width="200" align="center">
			</el-table-column>
			<el-table-column prop="sort" label="排序" width="140" align="center">
			</el-table-column>
			<el-table-column prop="valueStr" label="设置" width="140" align="center">
			</el-table-column>

			<el-table-column fixed="right" label="操作" width="200" align="center">
				<template slot-scope="scope">
					<el-button @click="handleEdit(scope.row)" type="primary" size="small" plain>编辑</el-button>
					<el-button type="danger" size="small" @click="delList(scope.row)">删除</el-button>
				</template>
			</el-table-column>
		</el-table>

		<div class="pagenum">
			<el-button size="mini" :disabled="firstPage" @click="goBack()" round>首页</el-button>
			<el-button size="mini" round :disabled="firstPage" @click="goPre()">上一页</el-button>
			<el-button size="mini" round disabled>{{ pagesNum }}</el-button>
			<el-button size="mini" :disabled="lastPage" @click="goNext()" round>下一页</el-button>
			<el-button size="mini" :disabled="lastPage" @click="goLast()" round>尾页</el-button>
		</div>
		<!-- 编辑 -->
		<el-dialog title="编辑" :visible.sync="dialogVisible" width="30%">
			<el-tabs v-model="activeName" type="card" @tab-click="handleTabsClick">
				<el-tab-pane label="中文" name="cn">
					<div class="newadditem">
						<span>规格名称：</span>
						<el-input v-model="langData.cn.name" placeholder="请输入属性名称"></el-input>
					</div>
					<div class="newadditem">
						<span>所属属性</span>
						<el-input v-model="categoryName" disabled></el-input>
					</div>
					<div class="newadditem">
						<span>排序</span>
						<el-input v-model="sort" oninput="value=value.replace(/[^\d]/g,'')"></el-input>
					</div>
					<div class="newadditem">
						<span>规格项</span>
						<el-input type="textarea" :rows="2" placeholder="请输入规格项，多个关键字用逗号隔开"
							v-model="langData.cn.values">
						</el-input>
					</div>
				</el-tab-pane>
				<el-tab-pane label="英文" name="en">
					<div class="newadditem">
						<span>规格名称：</span>
						<el-input v-model="langData.en.name" placeholder="请输入属性名称"></el-input>
					</div>
					<div class="newadditem">
						<span>所属属性</span>
						<el-input v-model="categoryName" disabled></el-input>
					</div>
					<div class="newadditem">
						<span>排序</span>
						<el-input v-model="sort" oninput="value=value.replace(/[^\d]/g,'')"></el-input>
					</div>
					<div class="newadditem">
						<span>规格项</span>
						<el-input type="textarea" :rows="2" placeholder="请输入规格项，多个关键字用逗号隔开"
							v-model="langData.en.values">
						</el-input>
					</div>
				</el-tab-pane>
				<el-tab-pane label="繁体" name="tw">
					<div class="newadditem">
						<span>规格名称：</span>
						<el-input v-model="langData.tw.name" placeholder="请输入属性名称"></el-input>
					</div>
					<div class="newadditem">
						<span>所属属性</span>
						<el-input v-model="categoryName" disabled></el-input>
					</div>
					<div class="newadditem">
						<span>排序</span>
						<el-input v-model="sort" oninput="value=value.replace(/[^\d]/g,'')"></el-input>
					</div>
					<div class="newadditem">
						<span>规格项</span>
						<el-input type="textarea" :rows="2" placeholder="请输入规格项，多个关键字用逗号隔开"
							v-model="langData.tw.values">
						</el-input>
					</div>
				</el-tab-pane>
			</el-tabs>
			<span slot="footer" class="dialog-footer">
				<el-button @click="dialogVisible = false">取 消</el-button>
				<el-button type="primary" @click="clickEdit"> 确 定 </el-button>
			</span>
		</el-dialog>
	</div>
</template>

<script>
	import {
		speciList,
		addSpeci,
		editSpeci,
		deleteSpeci,
		updateSpeciInfo,
	} from "@/api/index";
	export default {
		name: "specification",
		data() {
			return {
				categoryName: null,
				categoryId: null,
				sort: null,
				langData: {
					cn: {
						name: null,
						values: null,
						categoryId: null,
						sort: null
					},
					en: {
						name: null,
						values: null,
						categoryId: null,
						sort: null
					},
					tw: {
						name: null,
						values: null,
						categoryId: null,
						sort: null
					}
				},
				pagesNum: 1,
				tableData: [],
				dialogVisible: false,
				lastPage: false,
				firstPage: false,
				lastPageNum: 1,
				falg: false,
				activeName: "cn",
				lang: "cn",
			};
		},
		activated() {
			this.categoryName = this.$route.query.attribute;
			this.categoryId = this.$route.query.id;
			this.pagesNum = 1;
			this.getAttributeList();
		},
		methods: {
			toAdd() {
				this.dialogVisible = true;
				this.langData.cn.name = null;
				this.langData.cn.sort = null;
				this.langData.cn.id = null;
				this.langData.cn.values = null;
				this.langData.en.name = null;
				this.langData.en.sort = null;
				this.langData.en.id = null;
				this.langData.en.values = null;
				this.langData.tw.name = null;
				this.langData.tw.sort = null;
				this.langData.tw.id = null;
				this.langData.tw.values = null;
			},
			// 返回首页
			goBack() {
				this.pagesNum = 1
				this.getAttributeList();
			},
			// 跳到尾页
			goLast() {
				this.pagesNum = this.lastPageNum;
				this.getAttributeList();
			},
			goNext() {
				this.pagesNum += 1;
				this.getAttributeList();
			},
			goPre() {
				this.pagesNum -= 1;
				this.getAttributeList();
			},
			handleTabsClick(tab) {
				tab.index == 0 ? (this.lang = "cn") : (this.lang = "en");
			},
			getAttributeList() {
				let data = {
					pageNum: this.pagesNum,
					pageSize: 10,
					categoryId: this.categoryId,
				};
				speciList(data).then((res) => {
					this.tableData = res.data.elements;
					this.pagesNum = res.data.thisPageNumber;
					this.lastPageNum = res.data.totalPage || 1;
					if (res.data.lastElementNumber - res.data.firstElementNumber == 1) {
						this.falg = true;
					} else {
						this.falg = false;
					}
					console.log("this.flag ->", this.falg);
					if (res.data.lastPage) {
						this.lastPage = true;
					} else {
						this.lastPage = false;
					}
					if (res.data.thisPageNumber == 1) {
						this.firstPage = true;
					} else {
						this.firstPage = false;
					}
				});
			},
			handleEdit(row) {
				this.dialogVisible = true;
				updateSpeciInfo({
					id: row.id
				}).then((res) => {
					this.langData = res.data;
					this.sort = this.langData.cn.sort
				});
			},
			//  编辑
			clickEdit() {
				if (!this.langData.cn.name) {
					this.$message({
						type: "error",
						message: "请输入中文规格名称!",
					});
					return
				}
				if (!this.langData.en.name) {
					this.$message({
						type: "error",
						message: "请输入英文规格名称!",
					});
					return
				}

				if (!this.langData.tw.name) {
					this.$message({
						type: "error",
						message: "请输入繁体规格名称!",
					});
					return
				}

				if (!this.langData.cn.values) {
					this.$message({
						type: "error",
						message: "请输入中文规格项!",
					});
					return
				}
				if (!this.langData.en.values) {
					this.$message({
						type: "error",
						message: "请输入英文规格项!",
					});
					return
				}

				if (!this.langData.tw.values) {
					this.$message({
						type: "error",
						message: "请输入繁体规格项!",
					});
					return
				}
				this.langData.cn.categoryId = this.categoryId;
				this.langData.cn.sort = this.sort;
				this.langData.tw.categoryId = this.categoryId;
				this.langData.tw.sort = this.sort;
				this.langData.tw.categoryId = this.categoryId;
				this.langData.tw.sort = this.sort;
				console.log(this.langData)
				if (this.langData.cn.id) {
					editSpeci(this.langData).then((res) => {
						if (res.code == 0) {
							this.$message({
								type: "success",
								message: "更新成功!",
							});
							this.dialogVisible = false;
							this.getAttributeList(this.pagesNum)
						} else {
							this.$message({
								type: "error",
								message: res.data.msg,
							});
						}
					});
				} else {
					addSpeci(this.langData).then(res => {
						if (res.code == 0) {
							this.$message({
								type: "success",
								message: "增加成功!",
							});
							this.dialogVisible = false;
							this.getAttributeList(this.pagesNum)
						} else {
							this.$message({
								type: "error",
								message: res.data.msg,
							});
						}
					})
				}
			},
			delList(val) {
				this.id = val.id;
				this.$confirm("此操作将永久删除该规格, 是否继续?", "提示", {
						confirmButtonText: "确定",
						cancelButtonText: "取消",
						type: "warning",
					})
					.then(() => {
						deleteSpeci({
							id: this.id
						}).then((res) => {
							if (res.code == 0) {
								this.$message({
									type: "success",
									message: "删除成功!",
								});
								this.getAttributeList();
							}
						});
					})
					.catch(() => {
						this.$message({
							type: "info",
							message: "已取消删除",
						});
					});
			}
		},
	};
</script>
<style scoped>
	/deep/ .el-table__header-wrapper .el-checkbox {
		display: none;
	}

	.newadditem {
		margin: 10px 20px;
		display: flex;
		justify-content: space-between;
		align-items: center;
	}

	.newadditem>span {
		flex: 0 0 120px;
	}

	.pagenum {
		margin-top: 20px;
		display: flex;
		justify-content: flex-end;
	}

	.newadd {
		margin: 20px 0;
	}
</style>
