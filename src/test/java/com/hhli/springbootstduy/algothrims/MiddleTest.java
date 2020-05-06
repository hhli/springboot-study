package com.hhli.springbootstduy.algothrims;

/**
 * @author 李辉辉
 * @date 2020-05-02 08:41
 * @description 中位数
 */
public class MiddleTest {

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1,2}, new int[]{1, 1}));
    }

    //public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
    //    int len = nums1.length + nums2.length;
    //
    //    double middle = 0.0d;
    //    if((len+1)%2 == 0){
    //        int middleIndex = (len+1)/2;
    //        if(nums1.length == 0){
    //            return nums2[middleIndex-1] + 0.0;
    //        }else if(nums2.length==0){
    //            return nums1[middleIndex-1] + 0.0;
    //        }
    //
    //        int i=0, j=0,time=0;
    //        while (i<=nums1.length || j<=nums2.length){
    //            time++;
    //
    //            if(i == nums1.length || nums1[i]>nums2[j]){
    //                if(time == middleIndex){
    //                    middle += nums2[j];
    //                    break;
    //                }
    //                j++;
    //            }else if(j == nums2.length || nums1[i]<=nums2[j]){
    //                if(time == middleIndex){
    //                    middle += nums1[i];
    //                    break;
    //                }
    //                i++;
    //            }
    //        }
    //    }else{
    //        int leftIndex = (len)/2;
    //        int rightIndex = (len)/2 +1;
    //        if(nums1.length == 0){
    //            return nums2[leftIndex-1]/2.0 + nums2[rightIndex-1]/2.0;
    //        }else if(nums2.length==0){
    //            return nums1[leftIndex-1]/2.0 + nums1[rightIndex-1]/2.0;
    //        }
    //
    //        int i=0, j=0,time=0;
    //        while (i<=nums1.length || j<=nums2.length){
    //            time++;
    //
    //            if(i == nums1.length || nums1[i]>nums2[j]){
    //                if(time == leftIndex){
    //                    middle += nums2[j]/2.0;
    //                }
    //                if(time == rightIndex){
    //                    middle += nums2[j]/2.0;
    //                }
    //                j++;
    //            }else if(j == nums2.length || nums1[i]<=nums2[j]){
    //                if(time == leftIndex){
    //                    middle += nums1[i]/2.0;
    //                }
    //                if(time == rightIndex){
    //                    middle += nums1[i]/2.0;
    //                }
    //                i++;
    //            }
    //
    //            if(time>rightIndex){
    //                break;
    //            }
    //        }
    //
    //    }
    //
    //    return middle;
    //}


    public static double findMedianSortedArrays(int[] nums1, int[] nums2){
        if(nums1.length == 0){
            if(nums2.length%2 == 0){
                return nums2[(nums2.length-1)/2] + nums2[(nums1.length-1)/2];
            }else{
                return nums2[(nums2.length-1)/2];
            }
        }

        if(nums2.length == 0){
            return findMedianSortedArrays(nums2, nums1);
        }

        if(nums1[nums1.length-1]<nums2[0]){

        }else if(nums1[0]>nums2[nums2.length-1]){
            return  findMedianSortedArrays(nums2, nums1);

        }else{
            int i=0, j=0, temp=0;
            while (nums1[nums1.length-1]>=nums2[0]){
                if(nums1[i]>nums2[j]){

                }else{

                }
            }
        }

        
        return 0;
    }
}
