import request from './request'
// 获取列表
export function getList(data) {
  return request({
    url: 'wap/api/goodAttrCategory!list.action',
    method: 'post',
    data
  })
}
//新增属性
export function addAttrbute(data) {
  return request({
    url: 'wap/api/goodAttrCategory!add.action',
    method: 'post',
    data
  })
}
// 编辑属性
export function editAttrbute(data) {
  return request({
    url: 'wap/api/goodAttrCategory!update.action',
    method: 'post',
    data
  })
}
// 删除属性delete.action
export function delAttrbute(data) {
  return request({
    url: 'wap/api/goodAttrCategory!delete.action',
    method: 'post',
    data
  })
}
// 规则列表
export function speciList(data) {
  return request({
    url: 'wap/api/goodAttr!list.action',
    method: 'post',
    data
  })
}
//增加规格
export function addSpeci(data) {
  return request({
    url: 'wap/api/goodAttr!add.action',
    method: 'post',
    data
  })
}
//获取规格详情 api_war_exploded/api/goodAttr!getById.action
export function updateSpeciInfo(data) {
  return request({
    url: 'wap/api/goodAttr!getById.action',
    method: 'post',
    data
  })
}
// 编辑规格  
export function editSpeci(data) {
  return request({
    url: 'wap/api/goodAttr!update.action',
    method: 'post',
    data
  })
}
// 删除规格
export function deleteSpeci(data) {
  return request({
    url: 'wap/api/goodAttr!delete.action',
    method: 'post',
    data
  })
}